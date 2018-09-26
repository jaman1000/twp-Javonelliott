package Main.edu.bsu.cs222;

import java.util.ArrayList;

import java.util.List;


// initialize variables
    public class Editors {



        private List<Revision> revisions;

        private String username;

        private Integer i;



        public Editors (String username, Integer i){

            this.username = username;

            this.revisions = new ArrayList<Revision>();

            this.i = i;

        }



        public String getUsername(){

            return username;

        }



        public void addRevision(Revision revision){

            revisions.add(revision);

        }



        public Integer getNumberOfRevisions(){

            return i;

        }



        //processes the number of revisions

        public String toString(){

            String result = "";

            result += username + "\tNumber of Revisions: " + i ;

            for(int i = 0; i<revisions.size(); i++) {

                result += "\n \t\tRevision# : " + (i+1) + " " + revisions.get(i);

                if(i == revisions.size() - 1){

                    result+= "\n";

                }

            }

            result.replaceAll(",","");

            return result;

        }



        public void count(){

            i++;

        }

    }

