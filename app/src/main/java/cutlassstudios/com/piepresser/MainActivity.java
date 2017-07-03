    package cutlassstudios.com.piepresser;

    import android.content.Context;
    import android.content.SharedPreferences;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.EditText;
    import android.widget.ImageButton;
    import android.widget.TextView;
    import android.widget.Toast;

    import static java.security.AccessController.getContext;

    public class MainActivity extends AppCompatActivity {

        //EditText is basically just a field of text that the user can change with what they want.
        //In the app, it is that space where you saw "Enter Domo Name"
        private EditText nameBox;
        private String name;
        private Toast toast;
        //new


        //ImageButton is the pie image

        private ImageButton pie;
        private int counter = 0;

        //onCreateMethod is run infinitely
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //Assigning a reference to the XML file that holds the locations of each widget (EditText, Buttons, etc)

            setContentView(R.layout.activity_main);



            nameBox = (EditText)findViewById(R.id.editText);
            pie = (ImageButton)findViewById(R.id.imageButton);


            //sets the name in the text box
            nameBox.setText(getName(getApplicationContext()), TextView.BufferType.EDITABLE);




            //things that happen when the thing is clicked
            pie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //sets the score to the previous save
                    counter = getScore(getApplicationContext());
                    counter++;

                    //sets name to previous save
                      name = nameBox.getText().toString();

                    //cancels the previous toast to prevent back log
                if(toast != null)
                    toast.cancel();


                    //Creating a popup message that notifies the user of the number of pies
                    Context context = getApplicationContext();
                    saveScore(context, counter);
                    CharSequence text = "Greetings, " + name + "! You now have " + counter + " pies.";
                    int duration = Toast.LENGTH_SHORT;
                   // Toast toast = Toast.makeText(context, text, duration);
                    toast = Toast.makeText(context, text, duration);
                    toast.show();



                    saveName(getApplicationContext(),name);

                }
            });

        }

    //saves the score
    public void saveScore(Context context,int pies){

        SharedPreferences score = context.getSharedPreferences("Scores",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = score.edit();
        editor.putInt("score",pies);
        editor.commit();
    }
    //gets the current number of pies
    public int getScore(Context context){

            SharedPreferences score = context.getSharedPreferences("Scores", Context.MODE_PRIVATE);
            return score.getInt("score", 0); //0 is the value it returns if shit goes south

    }

    //saves the name
        public void saveName(Context context,String name){

            SharedPreferences nameSave= context.getSharedPreferences("Names",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = nameSave.edit();
            editor.putString("name",name);
            editor.commit();
        }

        //returns the name that was saved
        public String getName(Context context){

            SharedPreferences nameSave = context.getSharedPreferences("Names", Context.MODE_PRIVATE);
            return nameSave.getString("name", "Enter Domo Name"); //Enter Domo Name is the name it will originally show when first starting

        }

    }
