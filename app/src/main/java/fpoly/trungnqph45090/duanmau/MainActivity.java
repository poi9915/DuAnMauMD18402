package fpoly.trungnqph45090.duanmau;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import fpoly.trungnqph45090.duanmau.Fragments.QuanLyLoaiSachFragment;
import fpoly.trungnqph45090.duanmau.Fragments.QuanLyPhieuMuonFragment;
import fpoly.trungnqph45090.duanmau.Fragments.QuanLySachFragment;
import fpoly.trungnqph45090.duanmau.Fragments.QuanLyThanhVienFragment;

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawerLayout,
                toolbar,
                R.string.open,
                R.string.close
        );
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        setFragment(new QuanLyPhieuMuonFragment());
        toolbar.setTitle("Quản lý phiếu mượn");
        //tạo set fragment cho activity
        naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Quản lý Fragment
                if (item.getItemId() == R.id.imnu_QLpm) {
                    toolbar.setTitle("Quản lý phiếu mượn");
                    setFragment(new QuanLyPhieuMuonFragment());
                }if (item.getItemId() == R.id.imnu_QLls){
                    toolbar.setTitle("Quản Lý loai sach");
                    setFragment(new QuanLyLoaiSachFragment());
                }if (item.getItemId() == R.id.imnu_QLs){
                    toolbar.setTitle("Quản Lý Sách");
                    setFragment(new QuanLySachFragment());
                }if (item.getItemId() == R.id.imnu_QLtv){
                    toolbar.setTitle("Quản lý Thành Viên");
                    setFragment(new QuanLyThanhVienFragment());
                }
                //Thống Ke Fragment
                //Người Dủng Fragment
                drawerLayout.close();
                return true;
            }
        });
    }
    //hàm set fragment (dùng nhiều lần)
    public void setFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}