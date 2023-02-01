package run.budgetbuddy.utils

import android.app.Application
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import io.realm.RealmConfiguration

open class RealmHelp : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val conf =
            RealmConfiguration.Builder().name("budgetBuddy.db").deleteRealmIfMigrationNeeded()
                .schemaVersion(0).allowWritesOnUiThread(true).allowQueriesOnUiThread(true).build()
        Realm.setDefaultConfiguration(conf)
    }
}