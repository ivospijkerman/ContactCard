package nl.spijkerman.ivo.contactcard.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import nl.spijkerman.ivo.contactcard.R;
import nl.spijkerman.ivo.contactcard.adapter.ContactArrayAdapter;
import nl.spijkerman.ivo.contactcard.controller.ContactController;
import nl.spijkerman.ivo.contactcard.controller.ContactRepository;
import nl.spijkerman.ivo.contactcard.controller.ContactSource;
import nl.spijkerman.ivo.contactcard.model.Contact;

public class ContactListFragment extends Fragment {

    private  ListView contactListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);

        contactListView = view.findViewById(R.id.list_view_contacts);

        boolean useRepo = this.getActivity().getSharedPreferences(ContactSource.SOURCE_PREF, 0).getBoolean(ContactSource.USE_REPO, true);
        ContactSource contactSource = useRepo ? new ContactRepository(this.getContext()) : ContactController.INSTANCE;
        Contact[] allContacts = contactSource.getAll();
        ContactArrayAdapter adapter = new ContactArrayAdapter(this.getContext(), R.layout.list_item_contact, allContacts);

        contactListView.setAdapter(adapter);
        contactListView.setOnItemClickListener((MainActivity) this.getActivity());

        return view;
    }
}
