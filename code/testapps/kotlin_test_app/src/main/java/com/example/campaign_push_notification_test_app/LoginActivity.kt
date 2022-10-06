/*
  Copyright 2022 Adobe. All rights reserved.
  This file is licensed to you under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software distributed under
  the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
  OF ANY KIND, either express or implied. See the License for the specific language
  governing permissions and limitations under the License.
*/

package com.example.campaign_push_notification_test_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.campaign_push_notification_test_app.storage.PreferenceManager

class LoginActivity : AppCompatActivity(), LoginSuccessCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        addFragment()
    }

    private fun addFragment() {

        val fragment = if (PreferenceManager.isAccounctCreated(this)) LoginScreenFragment.newInstance()
        else SignUpScreenFragment.newInstance()
        supportFragmentManager.beginTransaction().add(fragment, "LoginFragment").commit()
    }

    override fun onSuccessFulLogin() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}