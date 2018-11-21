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

public class ContactListFragment extends Fragment {

    private  ListView contactListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);

        contactListView = view.findViewById(R.id.list_view_contacts);

        ContactArrayAdapter adapter = new ContactArrayAdapter(this.getContext(), R.layout.list_item_contact, ContactController.INSTANCE.getAll());

        contactListView.setAdapter(adapter);
        contactListView.setOnClickListener(this.getActivity());

        return view;
    }
}
