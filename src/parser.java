import java.io.FileReader;
import java.io.IOException;


public class parser {
    public static void main(String args[]) {
        //TODO
        Scanner sc = new Scanner();

        Scanner.Graph gra = new Scanner.Graph();
        parser ps = new parser();

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
        System.out.println("<Program>");
        stmt_list(ary);
        System.out.println("</Program>");
    }
    void stmt_list(String[] ary) {
        if (ary != null) {
            System.out.println("    <stmt_list>");
            stmt(ary);
            System.out.println("    </stmt_list>");
        }else{return;};

    }

    void stmt(String[] ary){
        System.out.println("        <stmt>");
        if(ary[0].equals("read")){
            readFnk(ary);
            if(ary[1].equals("id")){

                identifier(ary,3);
            }
        }
        else if(ary[0].equals("write")){
            writeFnk(ary);
        }
        else if(ary[1].equals("id")){

            if(ary[3].equals("assign")){
                System.out.println("/////////////////////");
                expr(ary,5);
            }
        }
        System.out.println("        </stmt>");
    }
    void readFnk(String[] ary){
        System.out.println("            <read>");
        System.out.println("                " + ary[0]);
        System.out.println("            </read>");
    }
    void identifier(String[] ary,int i){
        System.out.println("            <id>");
        System.out.println("                "+ary[i-1]);
        System.out.println("            </id>");
    }

    void numId(String[] ary,int i){
        System.out.println("            <number>");
        System.out.println("                "+ary[i-1]);
        System.out.println("            </number>");
    }

    void writeFnk(String[] ary){

        System.out.println("            <write>");
        System.out.println("                " + ary[0]);
        System.out.println("            </write>");
        expr(ary,3);
    }

    int expr(String[] ary, int i){
        System.out.println("                <expr>");
        term(ary,i);
        term_tail(ary,i+2);
        System.out.println("                </expr>");
        return i;
    }

    int term(String[] ary, int i){
        System.out.println("                    <term>");
        i =factor(ary,i);
        fact_tail(ary,i+2);
        System.out.println("                    </term>");
        return i;
    }

    void term_tail(String[] ary,int i){
        System.out.println("                    <term_tail>");
        if(i+2<= ary.length) {
            if ((ary[i].equals("plus")) || (ary[i].equals("minus"))) {
                add_op(ary, i);
                i = term(ary, i + 2);
                term_tail(ary, i);
            } else {
                return;
            }
        }
        System.out.println("                    </term_tail>");
    }

    int factor(String[] ary, int i){
        System.out.println("                    <factor>");
        //lparen <expr> rparen |id|number
        if(ary[i].equals("lParen")){
            expr(ary,i+2);
        }
        else if(ary[i].equals("id")){
            identifier(ary,i);
        }
        else if(ary[i].equals("number")){
            numId(ary,i);
        }
        System.out.println("                    </factor>");
        return i;
    }

    int fact_tail(String[] ary, int i){
        System.out.println("                    <fact_tail>");
        //<mult_op> <factor> <fact_tail> | e
        if((i+2)<= ary.length) {
        if((ary[i].equals("times"))||(ary[i].equals("div"))) {

                mult_op(ary, i);
                i = factor(ary, i + 2);
                fact_tail(ary, i);
            }
        }

        System.out.println("                    </fact_tail>");
        return i;
    }

    void add_op(String[] ary, int i){
        System.out.println("                        <add_op>");
        if(ary[i].equals("plus")){
            System.out.println("                            <plus>");
            System.out.println("                                "+ary[i-1]);
            System.out.println("                            </plus>");
        }
        else if(ary[i].equals("minus")){
            System.out.println("                            <minus>");
            System.out.println("                                "+ary[i-1]);
            System.out.println("                            </minus>");
        }

        System.out.println("                        </add_op>");
    }

    void mult_op(String[] ary, int i){
        System.out.println("                        <mult_op>");
        if(ary[i].equals("times")) {
            System.out.println("                            <times>");
            System.out.println("                                " + ary[i - 1]);
            System.out.println("                            </times>");
            System.out.println("                        </mult_op>");
        }
        else if(ary[i].equals("div")){
            System.out.println("                            <div>");
            System.out.println("                                "+ary[i-1]);
            System.out.println("                            </div>");
        }
    }
}