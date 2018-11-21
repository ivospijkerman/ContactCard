package nl.spijkerman.ivo.contactcard.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import nl.spijkerman.ivo.contactcard.R;
import nl.spijkerman.ivo.contactcard.controller.ContactController;
import nl.spijkerman.ivo.contactcard.model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Contact contact = ContactController.INSTANCE.getById(0);

        TextView deprecated = findViewById(R.id.deprecated);
        deprecated.setText(contact.name.first);
    }
}
