package com.enaitzdam.bottommenuzero

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.enaitzdam.bottommenuzero.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfig: AppBarConfiguration

    private lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)

        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment

        navController = navHostFragment.navController

        setupWithNavController(binding.bottomNavigationMenu, navController)

        setupWithNavController(binding.navView, navController)

        val toggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, R.string.obert, R.string.tancat)


        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        appBarConfig = AppBarConfiguration.Builder(R.id.favFragment)
            .setDrawerLayout(binding.drawerLayout)
            .build()
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig)




    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfig)
    }
}