import java.io.*;
import java.util.*;

class cord{
   public int x,y,no;
   char z;
   int d;
   public void shift(char d1){
     if(d1=='L'){
       if(d==3){
         d=0;
       }
       else{
         d+=1;
       }
     }
     else {
       if(d==0){
         d=3;
       }
       else{
         d-=1;
       }
     }
     if(d==0){
       z='S';
     }
     else if(d==1){
       z='E';
     }
     else if(d==2){
       z='N';
     }
     else{
       z='W';
     }
   }
  }

public class MarsProject{
  


  
  public static void main(String[] args){
    
    BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
    String s,path="";
    String s1,s2,s3;
    int i=0,j=1;
    int e,ex=0,ey=0;
    cord temp,crash=new cord();
    ArrayList<cord> startpoint= new ArrayList<cord>();
    try{
    s = br.readLine();
    while(!s.equals("DONE")){
      if(i==0){
        s1 = ""+s.charAt(0);
        s2 = ""+s.charAt(2);
        ex = Integer.parseInt(s1);
        ey = Integer.parseInt(s2); 
        ++i;
      }
      else if(i%2==1){
        s1 = ""+s.charAt(0);
        s2 = ""+s.charAt(2);
        s3 = ""+s.charAt(4);
        temp = new cord();
        temp.x = Integer.parseInt(s1);
        temp.y = Integer.parseInt(s2);
        temp.z = s3.charAt(0);
        temp.no = j;
        ++j;
        startpoint.add(temp);
        ++i;
      }
      else{ 
        path = s;
        ++i;
      }
      s = br.readLine();
    }      
    

      
    
    }catch(Exception exce){}
    
    int flag,flag1;
    for(cord trav:startpoint){
      
      for(int l =0;i<path.length();++l){
        flag=0;
        flag1=0;
        if(path.charAt(l)=='M'){
          if(trav.z=='S'){
             if(trav.x==0){
                flag=1;
                break;
              }
              for(cord vart:startpoint){
                if((vart.x==trav.x-1)&&(vart.y==trav.y)){
                  flag1=1;
                  break;
                }
              }
              if(flag1==1){
                break;
              }
              trav.x-=1;
           }  
           if(trav.z=='N'){
             if(trav.x==ex){
                flag=1;
                break;
              }
              for(cord vart:startpoint){
                if((vart.x==trav.x+1)&&(vart.y==trav.y)){
                  crash=vart;
                  flag1=1;
                  break;
                }
              }
              if(flag1==1){
                break;
              }
              trav.x-=1;
           }  
           if(trav.z=='W'){
             if(trav.y==0){
                flag=1;
                break;
              }
              for(cord vart:startpoint){
                if((vart.y==trav.y-1)&&(vart.x==trav.x)){
                  flag1=1;
                  break;
                }
              }
              if(flag1==1){
                break;
              }
              trav.x-=1;
           }  
           if(trav.z=='E'){
             if(trav.y==ey){
                flag=1;
                break;
              }
              for(cord vart:startpoint){
                if((vart.y==trav.y+1)&&(vart.x==trav.x)){
                  flag1=1;
                  break;
                }
              }
              if(flag1==1){
                break;
              }
              trav.x-=1;
           }  
           if(flag==1){
             System.out.println("The mars rover"+trav.no+" went out of bounds");
             break;
           }
           if(flag1==1){
             System.out.println("The mars rover"+trav.no+" hit mars rover"+crash.no);
             break;
           }
         }
         else{
           trav.shift(path.charAt(l));
         }
       }  
       System.out.println("The mars rover"+trav.no+" is at "+trav.x+" "+trav.y+" "+trav.z);
    }   
         
  }       
}      
                  
           
                     
             