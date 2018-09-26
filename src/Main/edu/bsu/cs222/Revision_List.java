package Main.edu.bsu.cs222;

import java.sql.Timestamp;

import java.util.*;
import java.util.List;

//import java.util.stream.Stream;



public class Revision_List {

    private List<Revision> revisions;



    public Revision_List(String searchTerm){

        Parser parser = new Parser(searchTerm);

        this.revisions = parser.getRevisions();



    }



    //ordering the Timestamps of the revisions so as to determine tie breakers as well as when revisions were made

    public List<Revision> sortTime(){

        for (int i=0;i<revisions.size();i++){

            for(int j=i+1;j<revisions.size();j++){

                Timestamp firstTime = revisions.get(i).getTime();

                Timestamp secondTime = revisions.get(j).getTime();

                if(firstTime.before(secondTime)){

                    Revision temp = revisions.get(i);

                    revisions.set(i,revisions.get(j) );

                    revisions.set(j,temp);

                }

            }

        }

        return revisions;

    }



    public List<Editors> inserteditors(){

        Set<String> set = new HashSet();

        Integer num_Revisions = 1;

        List<Editors> editors = new LinkedList<Editors>();

        for(int i =0;i<revisions.size();i++){

            String username = revisions.get(i).getUsername();

            Revision revision = revisions.get(i);



            if( set.add(username) == true){

                Editors contributor = new Editors(revisions.get(i).getUsername(),num_Revisions);

                set.add(username);

                Editors.addRevision(revision);

                editors.add(editors);

            } else{



                for(int j =0;j<editors.size();j++){

                    if(editors.get(j).getUsername().equals(username)) {

                        editors.get(j).addRevision(revision);

                        editors.get(j).count();

                    }

                }



            }

        }

        for(int i=0;i<editors.size();i++){

            Integer compareNumberOfEntries = editors.get(i).getNumberOfRevisions();

            for(int j=i+1;j<editors.size();j++){

                Integer secondCompareNumberOfEntries = editors.get(j).getNumberOfRevisions();

                if(compareNumberOfEntries<secondCompareNumberOfEntries){

                    Editors tempAuthor = editors.get(i);

                    editors.set(i,editors.get(j));

                    editors.set(j,tempAuthor);

                }

            }

        }

        editors = sortRevisions(editors);

        return editors;

    }
// sourced from




    public List<Editors> sortRevisions(List<Editors> authorList){

        for(int i=0;i<authorList.size();i++){

            Integer compareNumberOfEntries = authorList.get(i).getNumberOfRevisions();

            for(int j=i+1;j<authorList.size();j++){

                Integer secondCompareNumberOfEntries = authorList.get(j).getNumberOfRevisions();

                if(compareNumberOfEntries<secondCompareNumberOfEntries){

                    Editors tempContributor = authorList.get(i);

                    authorList.set(i,authorList.get(j));

                    authorList.set(j,tempContributor);

                }

            }

        }

        return authorList;



    }





    public int size(){

        return revisions.size();

    }



    public Revision get(int i){

        return revisions.get(i);

    }



    public boolean isEmpty(){

        if(this.revisions.isEmpty()){

            return true;

        }

        return false;

    }



    public String toString(){

        String result = "";

        for(int i =0;i<revisions.size();i++){

            result+= "Revisions by " + (i+1) + " -- " + revisions.get(i).toString() + "\n";

        }

        return result;

    }

}
// Sourced from Lauren Ravenell twp