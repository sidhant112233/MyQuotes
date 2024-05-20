package com.example.myquotes

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.myquotes.Fragment.HomeFragment
import com.example.myquotes.Fragment.LikeFragment
import com.example.myquotes.Fragment.ProfileFragment
import com.example.myquotes.databinding.ActivityMainBinding

lateinit var mainBinding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)





        mainBinding.imgMenu.setOnClickListener {

            mainBinding.main.openDrawer(Gravity.START)

            mainBinding.navigationDrawer.setNavigationItemSelectedListener {
                when (it.itemId) {

                    R.id.mHome -> {
                        mainBinding.main.closeDrawer(Gravity.START)
                        Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.mSettings -> {
                        mainBinding.main.closeDrawer(Gravity.START)
                        Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.mCall -> {
                        mainBinding.main.closeDrawer(Gravity.START)
                        Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.mGroup -> {
                        mainBinding.main.closeDrawer(Gravity.START)
                        Toast.makeText(this, "Group", Toast.LENGTH_SHORT).show()
                        true
                    }

                    else -> {
                        false
                    }
                }
            }
        }


        mainBinding.bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.Home -> {
                    loaderFragment(HomeFragment())
                    true
                }

                R.id.like -> {
                    loaderFragment(LikeFragment())
                    true
                }

                R.id.Profile -> {
                    loaderFragment(ProfileFragment())
                    true
                }

                else -> false
            }
        }
        loaderFragment(HomeFragment())


    }


    private fun loaderFragment(fragment: Fragment) {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.Flayout, fragment)
            .commit()
    }

}
