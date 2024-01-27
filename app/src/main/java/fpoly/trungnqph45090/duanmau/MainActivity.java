package fpoly.trungnqph45090.duanmau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import fpoly.trungnqph45090.duanmau.DAO.LoaiSachDAO;
import fpoly.trungnqph45090.duanmau.DAO.ThanhVienDAO;
import fpoly.trungnqph45090.duanmau.Models.LoaiSach;
import fpoly.trungnqph45090.duanmau.Models.ThanhVien;

public class MainActivity extends AppCompatActivity {

    MaterialToolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView naviView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        naviView = findViewById(R.id.naviView);
        setSupportActionBar(toolbar);
    }
}