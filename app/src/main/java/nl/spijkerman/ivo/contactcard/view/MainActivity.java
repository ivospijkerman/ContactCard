package nl.spijkerman.ivo.contactcard.view;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import nl.spijkerman.ivo.contactcard.R;
import nl.spijkerman.ivo.contactcard.controller.ContactController;
import nl.spijkerman.ivo.contactcard.controller.ContactRepository;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ContactDetailFragment detailFragment = (ContactDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_b);
//            detailFragment.drawFor(ContactController.INSTANCE.getById((int) id));
            // TODO use the contact.id for this
            detailFragment.drawFor(new ContactRepository(this).getById((int) id + 1));

        } else {
            Toast.makeText(this, "Please use the app in landscape mode to view details", Toast.LENGTH_SHORT).show();

        }

    }
}
