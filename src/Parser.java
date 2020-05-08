import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class Parser {
	
	static List<String> statements = new ArrayList<String>();
	
    public static void main(String args[]) {
		
        Scanner sc = new Scanner();

        Scanner.Graph gra = new Scanner.Graph();
        Parser ps = new Parser();

        String output = "";
        try (FileReader fr = new FileReader("test text.txt")) {
            int content;
            //System.out.printf("<Program>\n");
			
            while ((content = fr.read()) != -1) {
				output = "";
                output = sc.scan(fr, content, gra.start, gra, output);
				statements.add(output);

                //ps.stmt_list(ary,1);
                //System.out.println(" ");
            }
            //System.out.printf("</Program>\n");
			for(String s: statements) {
				System.out.println(s);
			}
			String[] ary = ps.strArray(statements.get(0));
			statements.remove(0);
			ps.program(ary);
        } catch (IOException e) {
            System.out.println("file not found");
        }
        //call scan until end of file is reached




    }
	
    String[] strArray(String str){
        String[] ary = str.split(" ");
        return ary;
    }
	
	void program(String[] ary) {
		System.out.println("<Program>");
		stmt_list(ary, 1);
		System.out.println("</Program>");
	}

	
    void stmt_list(String[] ary, int n) {
        if (ary.length > 0) {
			indent(n);
            System.out.printf("<stmt_list>\n");
			if(ary.length > 2) {
				stmt(ary, n+1);
			}
			try {
				String[] newAry = strArray(statements.get(0));
				statements.remove(0);
				stmt_list(newAry, n+1);
			} catch(Exception e) {
				stmt_list(new String[0], n+1);
			}
			indent(n);
            System.out.printf("</stmt_list>\n");
        }else{
			return;
		}
    }

    void stmt(String[] ary, int n){
		indent(n);
        System.out.printf("<stmt>\n");
		//indent(n+1);
		//System.out.printf(ary[0] + "\n");
        if(ary[0].equals("read")){
            readFnk(ary, n+1);
            if(ary[1].equals("id")){
                identifier(ary, n+1, 3);
            }
        }
        else if(ary[0].equals("write")){
            writeFnk(ary, n+1);
        }
        else if(ary[1].contains("id") && ary.length >= 4){
            if(ary[3].contains("assign")){
				//indent(n+1);
                expr(ary, n+1, 5);
            }
        }else{return;}
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
		indent(n);
        System.out.printf("</expr>\n");
        return i;
    }

    int term(String[] ary, int n, int i){
		indent(n);
        System.out.printf("<term>\n");
        i = factor(ary, n+1, i);
        fact_tail(ary, n+1, i+2);
		indent(n);
        System.out.printf("</term>\n");
        return i;
    }

    int term_tail(String[] ary, int n, int i){
		indent(n);
        System.out.printf("<term_tail>\n");
        if(i+2<= ary.length) {
            if ((ary[i].equals("plus")) || (ary[i].equals("minus"))) {

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
		if(ary.length > i) {
			if(ary[i].equals("lParen")){
				indent(n+1);
				System.out.printf(ary[i-1] + "\n");
				i = expr(ary, n+1, i+2);
				//System.out.println(")");
				indent(n+1);
				System.out.printf(ary[i+3] + "\n");
				indent(n);
				System.out.printf("</factor>\n");

				return i+4;
			}
			else if(ary[i].equals("id")){
				identifier(ary, n+1, i);
			}
			else if(ary[i].equals("number")){
				numId(ary, n+1, i);
			}
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
			if((ary[i].equals("times"))||(ary[i].equals("div"))) {
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
        if(ary[i].equals("plus")){
			indent(n+1);
            System.out.printf("<plus>\n");
			indent(n+2);
            System.out.printf(ary[i-1] + "\n");
			indent(n+1);
            System.out.printf("</plus>\n");
        }
        else if(ary[i].equals("minus")){
			indent(n+1);
            System.out.printf("<minus>\n");
			indent(n+2);
            System.out.printf(ary[i-1] + "\n");
			indent(n+1);
            System.out.printf("</minus>\n");
        }
		indent(n);
        System.out.printf("</add_op>\n");
    }

    void mult_op(String[] ary, int n, int i){
		indent(n);
        System.out.printf("<mult_op>\n");
        if(ary[i].equals("times")) {
			indent(n+1);
            System.out.printf("<times>\n");
			indent(n+2);
            System.out.printf(ary[i - 1] + "\n");
			indent(n+1);
            System.out.printf("</times>\n");
			indent(n);
            System.out.printf("</mult_op>\n");
        }
        else if(ary[i].equals("div")){
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