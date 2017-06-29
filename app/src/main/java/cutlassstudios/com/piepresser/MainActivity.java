package cutlassstudios.com.piepresser;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    //EditText is basically just a field of text that the user can change with what they want.
    //In the app, it is that space where you saw "Enter Domo Name"
    private EditText nameBox;
    private String name;

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
        pie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                name = nameBox.getText().toString();
                System.out.println(name);

                //Creating a popup message that notifies the user of the number of pies
                Context context = getApplicationContext();
                CharSequence text = "Greetings, " + name + "! You now have " + counter + " pies.";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }





}
