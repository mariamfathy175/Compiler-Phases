package fundmentals;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Fundmentals {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.println("please enter the source code");
        String code =in.nextLine();
        int number = 1;
        float num = 0;
        boolean sameletter = false;
        
        String[] tokens = code.split(" ");
        
        for(int i=0;i<tokens.length;i++)
        {    
            Boolean flag = tokens[i].matches("[a-zA-Z]");   
            if(flag)
            {  
	        for(int j = i + 1; j < tokens.length; j++) 
                {
  		      if(j != i && tokens[j].equals(tokens[i])) 
                      {
                         tokens[j]= tokens[j].replaceAll("[a-zA-Z]" , "id" + number);
                         sameletter = true;
		      }
                }
                tokens[i]= tokens[i].replaceAll("[a-zA-Z]" , "id" + number);
                number++;
            }
            System.out.print(tokens[i]);
        }
        System.out.print("\n"); 
           
        System.out.print("The Syntax tree is :\n");
        System.out.println(tokens[0]);
        System.out.print("   \\"+"\n"+"    ="+"\n"+"     \\"+"\n");
        System.out.println("      "+"+");
        System.out.println("     /"+" \\");
        System.out.println("   "+tokens[2]+"  "+"*");
        System.out.println("       /"+" \\");
        System.out.println("      "+tokens[4]+"  "+tokens[6]);
        
        String convert = "int to float"; 
        int flag2 = 0;

        String [] out = new String[3];
        StringBuilder b = new StringBuilder();
        for(int i=0;i<tokens.length;i++)
        { 
          b.append(tokens[i]).append("");
        }
        String str = b.toString();       
        
        Pattern p = Pattern.compile("[0-9]*\\.[0-9]*");
        Matcher m = p.matcher(str);
        
        while (m.find()) 
        {
          num = Float.parseFloat(m.group());
          flag2 = 1;
        }    
                
        if (flag2 == 1)
        {
          if (tokens[2].matches("[0-9]*\\.[0-9]*"))
          { 
           out[0]= "  ";   
           out[1]= convert +"("+ tokens[4]+")";
           out[2]= convert +"("+ tokens[6]+")";
          }
          else if (tokens[4].matches("[0-9]*\\.[0-9]*"))
          {
           out[1]= "  ";   
           out[0]= convert +"("+ tokens[2]+")";
           out[2]= convert +"("+ tokens[6]+")";
          }
          else
          {
           out[2]= "  ";   
           out[0]= convert +"("+ tokens[2]+")";
           out[1]= convert +"("+ tokens[4]+")";
          }
          System.out.print("The Semantic tree is :\n");
          System.out.println(tokens[0]);
          System.out.print("   \\"+"\n"+"    ="+"\n"+"     \\"+"\n");
          System.out.println("      "+"+");
          System.out.println("     /"+" \\");
          System.out.println("   "+tokens[2]+"  "+"*");
          System.out.println("   "+out[0]);
          System.out.println("       /"+" \\");
          System.out.println("      "+tokens[4]+"  "+tokens[6]);
          System.out.println("     "+out[1]+"  "+out[2]);
        }
        else
        {
          if(tokens[2].matches("[0-9]"))
          {
          out[0]= convert +"("+ tokens[2]+")";
          out[1]= "  ";
          out[2]= "  ";
            System.out.print("The Semantic tree is :\n");
            System.out.println(tokens[0]);
            System.out.print("   \\"+"\n"+"    ="+"\n"+"     \\"+"\n");
            System.out.println("      "+"+");
            System.out.println("     /"+" \\");
            System.out.println("   "+tokens[2]+".0"+"  "+"*");
            System.out.println("   "+out[0]);
            System.out.println("       /"+" \\");
            System.out.println("      "+tokens[4]+"  "+tokens[6]);
            System.out.println("     "+out[1]+"  "+out[2]);
          }
          else if (tokens[4].matches("[0-9]"))
          {
          out[1]= convert +"("+ tokens[4]+")"; 
          out[0]= "  ";
          out[2]= "  ";
            System.out.print("The Semantic tree is :\n");
            System.out.println(tokens[0]);
            System.out.print("   \\"+"\n"+"    ="+"\n"+"     \\"+"\n");
            System.out.println("      "+"+");
            System.out.println("     /"+" \\");
            System.out.println("   "+tokens[2]+"  "+"*");
            System.out.println("   "+out[0]);
            System.out.println("       /"+" \\");
            System.out.println("      "+tokens[4]+".0"+"  "+tokens[6]);
            System.out.println("     "+out[1]+"  "+out[2]);
          
          }
          else
          {
          out[2]= convert +"("+ tokens[6]+")";
          out[0]= "  ";
          out[1]= "  ";
            System.out.print("The Semantic tree is :\n");
            System.out.println(tokens[0]);
            System.out.print("   \\"+"\n"+"    ="+"\n"+"     \\"+"\n");
            System.out.println("      "+"+");
            System.out.println("     /"+" \\");
            System.out.println("   "+tokens[2]+"  "+"*");
            System.out.println("   "+out[0]);
            System.out.println("       /"+" \\");
            System.out.println("      "+tokens[4]+"  "+tokens[6]+".0");
            System.out.println("     "+out[1]+"  "+out[2]);
          }
          
        }
        
        System.out.println("ICG :");
        if(flag2 == 0)
        {
           if(tokens[2].matches("[0-9]"))
           {
            System.out.println("t1 = int to float ("+tokens[2]+")");       
            System.out.println("t2 = " +tokens[4]+" * "+ tokens[6]);
            System.out.println("t3 = t1 + t2 ");
            System.out.println("id1 = t3 ");
           }
           else if (tokens[4].matches("[0-9]"))
           {
            System.out.println("t1 = int to float ("+tokens[4]+")");       
            System.out.println("t2 = t1 * "+ tokens[6]);
            System.out.println("t3 = t2 + "+ tokens[2]);
            System.out.println("id1 = t3 ");
           }
           else
           {
            System.out.println("t1 = int to float ("+tokens[6]+")");       
            System.out.println("t2 = t1 * "+ tokens[4]);
            System.out.println("t3 = t2 + "+ tokens[2]);
            System.out.println("id1 = t3 ");
           } 
        }
        else
        {
           if(tokens[2].matches("[0-9]*\\.[0-9]*") && sameletter == false)
           {
            System.out.println("t1 = int to float ("+tokens[4]+")");       
            System.out.println("t2 = int to float ("+tokens[6]+")");
            System.out.println("t3 = t1 * t2");
            System.out.println("t4 = t3 + " + tokens[2]);
            System.out.println("id1 = t4");       
            
           }
           else if (tokens[2].matches("[0-9]*\\.[0-9]*")&& sameletter)
           {
            System.out.println("t1 = int to float ("+tokens[6]+")");       
            System.out.println("t2 = t1 * t1");
            System.out.println("t3 = t2 + " + tokens[2]);
            System.out.println("id1 = t3"); 
           }
           
           else if (tokens[4].matches("[0-9]*\\.[0-9]*") && sameletter == false)
           {
            System.out.println("t1 = int to float ("+tokens[6]+")");       
            System.out.println("t2 = int to float ("+tokens[2]+")");      
            System.out.println("t3 = t1 * "+tokens[4]);
            System.out.println("t4 = t3 + t2 ");
            System.out.println("id1 = t4"); 
           }
           else if (tokens[4].matches("[0-9]*\\.[0-9]*")&& sameletter)
           {
            System.out.println("t1 = int to float ("+tokens[6]+")");       
            System.out.println("t2 = t1 * "+tokens[4]);
            System.out.println("t3 = t2 + t1");
            System.out.println("id1 = t3"); 
           }
           else if (tokens[6].matches("[0-9]*\\.[0-9]*")&& sameletter)
           {
            System.out.println("t1 = int to float ("+tokens[4]+")");       
            System.out.println("t2 = t1 * "+tokens[6]);
            System.out.println("t3 = t2 + t1 ");
            System.out.println("id1 = t3");
           }
           else
           {
            System.out.println("t1 = int to float ("+tokens[4]+")");       
            System.out.println("t2 = int to float ("+tokens[2]+")");      
            System.out.println("t3 = t1 * "+tokens[6]);
            System.out.println("t4 = t2 + t3 ");
            System.out.println("id1 = t4"); 
           } 
        
        }
        System.out.println("");
        System.out.println("optimizer :");
         
        if(flag2 == 0)
        {
         if(tokens[2].matches("[0-9]"))
           {
            System.out.println("t1 = int to float ("+tokens[2]+")");
            System.out.println("t2= "+tokens[4]+" * "+tokens[6]);
            System.out.println("id1 = t1 + t2 ");
           }
           else if (tokens[4].matches("[0-9]"))
           {
            System.out.println("t1 = #" + tokens[4]+".0 * " + tokens[6]);       
            System.out.println("id1 = t1 + "+ tokens[2]);
           }
           else
           {
            System.out.println("t1 = #" + tokens[6]+".0 * " + tokens[4]);       
            System.out.println("id1 = t1 + "+ tokens[2]);
           } 
        }
        else
        {
          if(tokens[2].matches("[0-9]*\\.[0-9]*"))
           {
            System.out.println("t1 = #"+tokens[4]+" * #"+tokens[4]);       
            System.out.println("id1 = "+tokens[2]+" + t1");       
            
           }
           else if (tokens[4].matches("[0-9]*\\.[0-9]*"))
           {
            System.out.println("t1 = #"+tokens[6]+" * "+tokens[4]);       
            System.out.println("id1 = #"+tokens[2]+" + t1");      
           }
           else
           {
            System.out.println("t1 = #"+tokens[4]+" * "+tokens[6]);       
            System.out.println("id1 = #"+tokens[2]+" + t1");
           } 
        }
        System.out.println("");
        System.out.println("code generator:");
        
        if(flag2 == 0)
        { 
           if(tokens[2].matches("[0-9]") && sameletter == false)
           {
            System.out.println("LDF   R1,"+tokens[6]);       
            System.out.println("LDF   R2,"+tokens[4]);
            System.out.println("MULF  R1,R1,R2");
            System.out.println("ADDF  R1,R1,"+tokens[2]+".0");
            System.out.println("STRF  id1,R1");
           }
           
           else if(tokens[2].matches("[0-9]")&& sameletter)
           {
            System.out.println("LDF   R1,"+tokens[6]);       
            System.out.println("MULF  R1,R1,R1");
            System.out.println("LDF   R2,R1");
            System.out.println("ADDF  R2,R2,"+tokens[2]+".0");
            System.out.println("STRF  id1,R2");
           }
           else if (tokens[4].matches("[0-9]")&& sameletter == false)
           {
            System.out.println("LDF   R1,"+tokens[6]);       
            System.out.println("MULF  R1,R1,"+tokens[4]+".0");
            System.out.println("LDF   R2,"+tokens[2]);
            System.out.println("ADDF  R2,R2,R1");
            System.out.println("STRF  id1,R2");
           }
           else if (tokens[4].matches("[0-9]")&& sameletter)
           {
            System.out.println("LDF   R1,"+tokens[6]);       
            System.out.println("MULF  R1,R1,"+tokens[4]+".0");
            System.out.println("LDF   R2,R1");
            System.out.println("ADDF  R2,R2,R1");
            System.out.println("STRF  id1,R2");
           }
           else if (tokens[6].matches("[0-9]")&& sameletter)
           {
            System.out.println("LDF   R1,"+tokens[4]);       
            System.out.println("MULF  R1,R1,"+tokens[6]+".0");
            System.out.println("LDF   R2,R1");
            System.out.println("ADDF  R2,R2,R1");
            System.out.println("STRF  id1,R2");
           }
           else
           {
            System.out.println("LDF   R1,"+tokens[4]);       
            System.out.println("MULF  R1,R1,"+tokens[6]+".0");
            System.out.println("LDF   R2,"+tokens[2]);
            System.out.println("ADDF  R2,R2,R1");
            System.out.println("STRF  id1,R2");
           } 
        }
        else
        {
           if(tokens[2].matches("[0-9]*\\.[0-9]*")&& sameletter == false)
           {
            System.out.println("LDF   R1,"+tokens[6]);       
            System.out.println("LDF   R2,"+tokens[4]);
            System.out.println("MULF  R1,R1,R2");
            System.out.println("ADDF  R1,R1,"+tokens[2]);
            System.out.println("STRF  id1,R1");       
           }
           else if(tokens[2].matches("[0-9]*\\.[0-9]*")&& sameletter)
           {
            System.out.println("LDF   R1,"+tokens[6]);       
            System.out.println("MULF  R1,R1,R1");
            System.out.println("LDF   R2,R1");
            System.out.println("ADDF  R2,R2,"+tokens[2]);
            System.out.println("STRF  id1,R2");
           }
           else if (tokens[4].matches("[0-9]*\\.[0-9]*")&& sameletter == false)
           {
            System.out.println("LDF   R1,"+tokens[6]);       
            System.out.println("MULF  R1,R1,"+num);
            System.out.println("LDF   R2,"+tokens[2]);
            System.out.println("ADDF  R2,R2,R1");
            System.out.println("STRF  id1,R2");      
           }
           else if (tokens[4].matches("[0-9]*\\.[0-9]*")&& sameletter)
           {
            System.out.println("LDF   R1,"+tokens[6]);       
            System.out.println("MULF  R1,R1,"+tokens[4]);
            System.out.println("LDF   R2,R1");
            System.out.println("ADDF  R2,R2,R1");
            System.out.println("STRF  id1,R2");
           }
           else if (tokens[6].matches("[0-9]*\\.[0-9]*")&& sameletter)
           {
            System.out.println("LDF   R1,"+tokens[6]);       
            System.out.println("MULF  R1,R1,"+tokens[4]);
            System.out.println("LDF   R2,R1");
            System.out.println("ADDF  R2,R2,R1");
            System.out.println("STRF  id1,R2");
           }
           else
           {
            System.out.println("LDF   R1,"+tokens[4]);       
            System.out.println("MULF  R1,R1,"+tokens[6]);
            System.out.println("LDF   R2,"+tokens[2]);
            System.out.println("ADDF  R2,R2,R1");
            System.out.println("STRF  id1,R2");
           } 
        }
    }
}
// y = x + 3 * z 
// z = y + 2.9 * x
