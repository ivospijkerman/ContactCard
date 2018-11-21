package nl.spijkerman.ivo.contactcard.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.stream.Collectors;

import nl.spijkerman.ivo.contactcard.R;
import nl.spijkerman.ivo.contactcard.controller.ContactController;
import nl.spijkerman.ivo.contactcard.model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView deprecated = findViewById(R.id.deprecated);
        deprecated.setText(ContactController.INSTANCE.getAll().stream().map(c -> c.name.first + " " + c.name.last).collect(Collectors.joining("\n")));
    }
}
