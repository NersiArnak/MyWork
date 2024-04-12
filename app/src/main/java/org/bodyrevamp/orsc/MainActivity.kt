package org.bodyrevamp.orsc

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.bodyrevamp.orsc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)

        window.statusBarColor = ContextCompat.getColor(this, R.color.navi_blue)
        window.navigationBarColor = ContextCompat.getColor(this, R.color.specific_blue)


        val navController = findNavController(R.id.nav_host_fragment_content_main)  // Находит контроллер навигации по идентификатору фрагмента навигации
        appBarConfiguration = AppBarConfiguration(navController.graph)  // Создает конфигурацию панели действий на основе графа навигации
        setupActionBarWithNavController(navController, appBarConfiguration)  // Настраивает панель действий для работы с контроллером навигации

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {  // Определяет, какой элемент был выбран
                R.id.myResults -> {
                    navController.navigate(
                        R.id.ResultsFragment, null,
                        NavOptions.Builder()
                            .setLaunchSingleTop(true)
                            .setPopUpTo(R.id.ResultsFragment, true)
                            .build()
                    )
                }
                R.id.training -> {
                    navController.navigate(
                        R.id.TrainingsFragment, null,
                        NavOptions.Builder()
                            .setLaunchSingleTop(true)
                            .build()
                    )
                }
                R.id.timer -> {
                    binding.textMain.text = "Таймер"
                    true
                }
                R.id.nutrition -> {
                    navController.navigate(
                        R.id.NutritionFragment, null,
                        NavOptions.Builder()
                            .setLaunchSingleTop(true)
                            .build()
                    )
                }
                R.id.settings -> {
                    binding.textMain.text = "Настройки"
                    true
                }
            }
            true
        }
    }
}
