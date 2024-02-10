package fpoly.trungnqph45090.duanmau.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fpoly.trungnqph45090.duanmau.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuanLySachFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuanLySachFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public QuanLySachFragment() {
        // Required empty public constructor
    }


    public static QuanLySachFragment newInstance(String param1, String param2) {
        QuanLySachFragment fragment = new QuanLySachFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quan_ly_sach, container, false);
    }
}