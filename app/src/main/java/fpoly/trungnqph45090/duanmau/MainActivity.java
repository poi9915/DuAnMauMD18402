package fpoly.trungnqph45090.duanmau;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import fpoly.trungnqph45090.duanmau.Fragments.DoiMatKhauFragment;
import fpoly.trungnqph45090.duanmau.Fragments.QuanLyLoaiSachFragment;
import fpoly.trungnqph45090.duanmau.Fragments.QuanLyPhieuMuonFragment;
import fpoly.trungnqph45090.duanmau.Fragments.QuanLySachFragment;
import fpoly.trungnqph45090.duanmau.Fragments.QuanLyThanhVienFragment;
import fpoly.trungnqph45090.duanmau.Fragments.ThemThanhVienFragment;
import fpoly.trungnqph45090.duanmau.Fragments.TopFragment;

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
        setFragment(new QuanLyPhieuMuonFragment(),"Quản lý phiếu mượn");
        //tạo set fragment cho activity
        naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Quản lý Fragment
                if (item.getItemId() == R.id.imnu_QLpm) {
                    setFragment(new QuanLyPhieuMuonFragment(), "Quản lý phiếu mượn");
                }
                if (item.getItemId() == R.id.imnu_QLls) {
                    setFragment(new QuanLyLoaiSachFragment(), "Quản Lý loai sach");
                }
                if (item.getItemId() == R.id.imnu_QLs) {
                    setFragment(new QuanLySachFragment(), "Quản Lý Sách");
                }
                if (item.getItemId() == R.id.imnu_QLtv) {
                    setFragment(new QuanLyThanhVienFragment(), "Quản lý Thành Viên");
                }
                //Thống Ke Fragment
                if (item.getItemId() == R.id.inmu_TopBook){
                    setFragment(new TopFragment() , "Top sách");
                }
                //Người Dủng Fragment
                if (item.getItemId() == R.id.inmu_add_user){
                    setFragment(new ThemThanhVienFragment() , "Thêm thành viên");
                }
                if (item.getItemId() == R.id.inmu_change_pass){
                    setFragment(new DoiMatKhauFragment(),"Đổi mật khẩu");
                }
                if (item.getItemId()==R.id.imnu_logout){
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                }
                drawerLayout.close();
                return true;
            }
        });
    }

    //hàm set fragment (dùng nhiều lần)
    public void setFragment(Fragment fragment, String toolbarTitle) {
        getSupportActionBar().setTitle(toolbarTitle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}