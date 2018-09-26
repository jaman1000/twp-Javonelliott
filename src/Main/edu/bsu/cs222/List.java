package Main.edu.bsu.cs222;


// create a list of the Editors.
public class List{

    private List<Editors> editorsList;


    public List(String searchTerm) {

        List revisions = new List(searchTerm);

        this.editorsList = revisions.inserteditors();

    }

    // a toString method for the list of editors
    public String toString() {

        String result = "";

        for (int i = 0; i < editorsList.size(); i++) {

            result += "Editior" + (i + 1) + editorsList.get(i).toString();

        }

        return result;
    }

// get the size of the editor list
    private int size() {
        return editorsList.size();
    }

}
// sourced from lauren ravenell.
//added comments
// changed and incorporated my own variables from the Editor class
// altered formatting for cleaner code.
// added size method