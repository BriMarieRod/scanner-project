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
                output = sc.scan(fr, content, gra.start, gra, output);
                String[] ary = ps.strArray(output);
                /*for(int i=0; i<ary.length;i++){
                System.out.println(i+"--"+ary[i]);}*/
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
                identifier(ary);
            }
        }
        else if(ary[0].equals("write")){

        }
        else if(ary[1].equals("id")){
            if(ary[2].equals("assign")){
                expr(ary);
            }
        }
        System.out.println("        </stmt>");
    }
    void readFnk(String[] ary){
        System.out.println("            <read>");
        System.out.println("                " + ary[0]);
        System.out.println("            </read>");
    }
    void identifier(String[] ary){
        System.out.println("            <id>");
        System.out.println("                "+ary[2]);
        System.out.println("            </id>");
    }
    void writeFnk(String[] ary){
        System.out.println("            <write>");
        expr(ary);
        System.out.println("            </write>");
    }

    void expr(String[] ary){
        System.out.println("                <expr>");

        System.out.println("                </expr>");
    }
}