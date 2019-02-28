package nl.spijkerman.ivo.contactcard.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import nl.spijkerman.ivo.contactcard.R;
import nl.spijkerman.ivo.contactcard.controller.ContactController;
import nl.spijkerman.ivo.contactcard.controller.ContactRepository;
import nl.spijkerman.ivo.contactcard.controller.ContactSource;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static android.widget.Toast.LENGTH_SHORT;
import static nl.spijkerman.ivo.contactcard.R.id.fragment_b;
import static nl.spijkerman.ivo.contactcard.R.string.SOURCE_PREF;
import static nl.spijkerman.ivo.contactcard.R.string.USE_REPO;
import static nl.spijkerman.ivo.contactcard.R.string.source_controller;
import static nl.spijkerman.ivo.contactcard.R.string.source_repo;
import static nl.spijkerman.ivo.contactcard.controller.ContactController.INSTANCE;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE) {
            ContactDetailFragment detailFragment = (ContactDetailFragment) getFragmentManager().findFragmentById(fragment_b);

            boolean useRepo = getSharedPreferences(getString(SOURCE_PREF), 0).getBoolean(getString(USE_REPO), true);
            Log.i("grep", "MainActivity.onItemClick: useRepo = " + useRepo);
            final ContactSource contactSource;

            if (useRepo) {
                contactSource = new ContactRepository(this);
                id++; // since this source is 1-based instead of 0-based
            } else {
                contactSource = INSTANCE;
            }

            // TODO use the contact.id for this
            detailFragment.drawFor(contactSource.getById((int) id));

        } else {
            Toast.makeText(this, "Please use the app in landscape mode to view details", LENGTH_SHORT).show();

        }

    }

    public void onClick(View view) {
        TextView indicator = findViewById(R.id.text_view_indicator);
        Switch sourceSelector = findViewById(R.id.switch_source_selector);

        SharedPreferences.Editor sourceSettingsEditor = getSharedPreferences(getString(SOURCE_PREF), 0).edit();

        boolean useRepo = sourceSelector.isChecked();
        Log.i("grep", "MainActivity.onClick: useRepo = " + useRepo);
        indicator.setText(getString(useRepo
                ? source_repo
                : source_controller));

        sourceSettingsEditor.putBoolean(getString(R.string.USE_REPO), useRepo);
        sourceSettingsEditor.apply();
    }
}
