/**
 * User: Alexandr
 * Date: 08.10.2014
 */
public class Trening {
    String name;
    Trening[] children;
//    int[] recto;
 //   public Trening () int[]recto =  {1,2,
        public Trening(String treingName){
        name = treingName;
    }
    public Trening( String name, Trening[] children){}

    public void record(int add) {
        for(int i = 0; i < children.length; i++){
            Trening child =children[i];
            System.out.println(child.name);

        }
    }
    public void print(){
        int t = 0;
        int[]recto =  {1,2,3,0};
        for (int i =0; i < recto.length; i++){
            System.out.println("добавить запись");
            System.out.println("Просмотреть справочник");
            System.out.println("Удалить запись");
            System.out.println("Выход");

        }
    }



    public void view (int directory){}




    public  void renove (int text){}

}
