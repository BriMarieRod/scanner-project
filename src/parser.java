import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class Parser {
	
    public static void main(String args[]) {
		
        Scanner sc = new Scanner();

        Scanner.Graph gra = new Scanner.Graph();
        Parser ps = new Parser();

        String output = "";
        try (FileReader fr = new FileReader("test text.txt")) {
            int content;

            while ((content = fr.read()) != -1) {

                output = "";
                output = sc.scan(fr, content, gra.start, gra, output);
                String[] ary = ps.strArray(output);
                System.out.println(output);

                /*for (int i = 0; i < ary.length; i++) {
                    System.out.print(" "+i + "--" + ary[i]);
                }*/

                ps.program(ary);

            }
        } catch (IOException e) {
            System.out.println("file not found");
        }
        //call scan until end of file is reached
        System.out.println(output);



    }
	
    String[] strArray(String str){
        String[] ary = str.split(" ");
        return ary;
    }

    void program(String[] ary) {
        System.out.printf("<Program>\n");
        stmt_list(ary, 1);
        System.out.printf("</Program>\n");
    }
	
    void stmt_list(String[] ary, int n) {
        if (ary.length > 0) {
			indent(n);
            System.out.printf("<stmt_list>\n");
            stmt(ary, n+1);
			indent(n);
            System.out.printf("</stmt_list>\n");
			stmt_list(Arrays.copyOfRange(ary, 1, ary.length), n+1);
        }else{
			return;
		}
    }

    void stmt(String[] ary, int n){
		indent(n);
        System.out.printf("<stmt>\n");
		//indent(n+1);
		//System.out.printf(ary[0] + "\n");
        if(ary[0].contains("read")){
            readFnk(ary, n+1);
            if(ary[1].contains("id")){
                identifier(ary, n+1, 3);
            }
        }
        else if(ary[0].contains("write")){
            writeFnk(ary, n+1);
        }
        else if(ary[1].contains("id")){

            if(ary[3].contains("assign")){
                System.out.printf("/////////////////////\n");
                expr(ary, n+1, 5);
            }
        }
		indent(n);
        System.out.printf("</stmt>\n");
    }
	
    void readFnk(String[] ary, int n){
		indent(n);
        System.out.printf("<read>\n");
		indent(n+1);
        System.out.printf(ary[0] + "\n");
		indent(n);
        System.out.printf("</read>\n");
    }
	
    void identifier(String[] ary, int n, int i){
		indent(n);
        System.out.printf("<id>\n");
		indent(n+1);
        System.out.printf(ary[i-1] + "\n");
		indent(n);
        System.out.printf("</id>\n");
    }

    void numId(String[] ary, int n, int i){
		indent(n);
        System.out.printf("<number>\n");
		indent(n+1);
        System.out.printf(ary[i-1] + "\n");
		indent(n);
        System.out.printf("</number>\n");
    }

    void writeFnk(String[] ary, int n){
		indent(n);
        System.out.printf("<write>\n");
		indent(n+1);
        System.out.printf(ary[0] + "\n");
		indent(n);
        System.out.printf("</write>\n");
        expr(ary, n, 3);
    }

    int expr(String[] ary, int n, int i){
		indent(n);
        System.out.printf("<expr>\n");
        i = term(ary, n+1, i);
        i = term_tail(ary, n+1, i+2);
        System.out.printf("</expr>\n");
        return i;
    }

    int term(String[] ary, int n, int i){
		indent(n);
        System.out.printf("<term>\n");
        i = factor(ary, n+1, i);
        fact_tail(ary, n+1, i+2);
        System.out.printf("</term>\n");
        return i;
    }

    int term_tail(String[] ary, int n, int i){
		indent(n);
        System.out.printf("<term_tail>\n");
        if(i+2<= ary.length) {
            if ((ary[i].contains("plus")) || (ary[i].contains("minus"))) {

                add_op(ary, n+1, i);
                i = term(ary, n+1, i + 2);
                term_tail(ary, n+1, i);

            }
        }
		indent(n);
        System.out.printf("</term_tail>\n");
            return i;
    }

    int factor(String[] ary, int n, int i){
		indent(n);
        System.out.printf("<factor>\n");
        //lparen <expr> rparen |id|number
        if(ary[i].contains("lParen")){
			indent(n+1);
            System.out.printf(ary[i-1]);
            i = expr(ary, n+1, i+2);
            //System.out.println(")");
			indent(n+1);
            System.out.printf(ary[i+3]);
            System.out.printf("</factor>\n");

            return i+4;
        }
        else if(ary[i].contains("id")){
            identifier(ary, n+1, i);
        }
        else if(ary[i].contains("number")){
            numId(ary, n+1, i);
        }
		indent(n);
        System.out.printf("</factor>\n");
        return i;
    }

    int fact_tail(String[] ary, int n, int i){
		indent(n);
        System.out.printf("<fact_tail>\n");
        //<mult_op> <factor> <fact_tail> | e
        if((i+2)<= ary.length) {
        if((ary[i].contains("times"))||(ary[i].contains("div"))) {
                mult_op(ary, n+1, i);
                i = factor(ary, n+1, i + 2);
                fact_tail(ary, n+1, i);
            }
        }
		indent(n);
        System.out.printf("</fact_tail>\n");
        return i;
    }

    void add_op(String[] ary, int n, int i){
		indent(n);
        System.out.printf("<add_op>\n");
        if(ary[i].contains("plus")){
			indent(n+1);
            System.out.printf("<plus>");
			indent(n+2);
            System.out.printf(ary[i-1] + "\n");
			indent(n+1);
            System.out.printf("</plus>" + "\n");
        }
        else if(ary[i].contains("minus")){
			indent(n+1);
            System.out.printf("<minus>\n");
			indent(n+2);
            System.out.printf(ary[i-1] + "\n");
			indent(n+1);
            System.out.printf("</minus>");
        }
		indent(n);
        System.out.printf("</add_op>\n");
    }

    void mult_op(String[] ary, int n, int i){
		indent(n);
        System.out.printf("<mult_op>\n");
        if(ary[i].contains("times")) {
			indent(n+1);
            System.out.printf("<times>\n");
			indent(n+2);
            System.out.printf(ary[i - 1] + "\n");
			indent(n+1);
            System.out.printf("</times>\n");
			indent(n);
            System.out.printf("</mult_op>\n");
        }
        else if(ary[i].contains("div")){
			indent(n+1);
            System.out.printf("<div>\n");
			indent(n+2);
            System.out.printf(ary[i-1] + "\n");
			indent(n+1);
            System.out.printf("</div>\n");
        }
    }
	
	void indent(int n) {
		for(int i = 0; i < n; i++) {
			System.out.printf("\t");
		}
	}
	
}