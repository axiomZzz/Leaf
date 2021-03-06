package com.github.axiomzzz.leaf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment? ?: return

        val navController = host.navController


        bottom_nav_view.setupWithNavController(navController)

        bottom_nav_view.setOnNavigationItemReselectedListener {
            it.isEnabled=true //// !!!!!!!!!!!!!!!!!!!!!!!!!!! Блокирует двойной клик

        }
    }
}
