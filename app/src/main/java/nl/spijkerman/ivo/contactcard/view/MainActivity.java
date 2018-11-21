package nl.spijkerman.ivo.contactcard.view;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import nl.spijkerman.ivo.contactcard.R;
import nl.spijkerman.ivo.contactcard.controller.ContactController;
import nl.spijkerman.ivo.contactcard.model.Contact;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ContactDetailFragment detailFragment = (ContactDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_b);

        detailFragment.drawFor(ContactController.INSTANCE.getById((int) id));
    }
}
