package nl.spijkerman.ivo.contactcard.view;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import nl.spijkerman.ivo.contactcard.adapter.ContactArrayAdapter;
import nl.spijkerman.ivo.contactcard.controller.ContactRepository;
import nl.spijkerman.ivo.contactcard.controller.ContactSource;
import nl.spijkerman.ivo.contactcard.model.Contact;

import static nl.spijkerman.ivo.contactcard.R.id.list_view_contacts;
import static nl.spijkerman.ivo.contactcard.R.layout.fragment_contact_list;
import static nl.spijkerman.ivo.contactcard.R.layout.list_item_contact;
import static nl.spijkerman.ivo.contactcard.R.string.SOURCE_PREF;
import static nl.spijkerman.ivo.contactcard.R.string.USE_REPO;
import static nl.spijkerman.ivo.contactcard.controller.ContactController.INSTANCE;

public class ContactListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(fragment_contact_list, container, false);

        ListView contactListView = view.findViewById(list_view_contacts);

        final Context ctx = this.getContext();

        boolean useRepo = ctx.getSharedPreferences(ctx.getString(SOURCE_PREF), 0).getBoolean(ctx.getString(USE_REPO), true);
        Log.i("grep", "ContactListFragment.onCreateView: useRepo = " + useRepo);
        ContactSource contactSource = useRepo ? new ContactRepository(this.getContext()) : INSTANCE;
        Contact[] allContacts = contactSource.getAll();
        ContactArrayAdapter adapter = new ContactArrayAdapter(this.getContext(), list_item_contact, allContacts);

        contactListView.setAdapter(adapter);
        contactListView.setOnItemClickListener((MainActivity) this.getActivity());

        return view;
    }
}
