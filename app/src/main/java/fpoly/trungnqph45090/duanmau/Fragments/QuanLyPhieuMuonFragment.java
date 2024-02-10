package fpoly.trungnqph45090.duanmau.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fpoly.trungnqph45090.duanmau.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuanLyPhieuMuonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuanLyPhieuMuonFragment extends Fragment {

    public QuanLyPhieuMuonFragment() {

    }


    public static QuanLyPhieuMuonFragment newInstance(String param1, String param2) {
        QuanLyPhieuMuonFragment fragment = new QuanLyPhieuMuonFragment();

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
        return inflater.inflate(R.layout.fragment_quan_ly_phieu_muon, container, false);
    }
}