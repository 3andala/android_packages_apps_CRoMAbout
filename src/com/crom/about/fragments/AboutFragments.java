/*
 * Copyright (C) 2012 Crossbones Software
 * This code has been modified.  Portions copyright (C) 2013, Carbon Development
 * This code has been modified.  Portions copyright (C) 2014 C-RoM Development
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.crom.about.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.crom.about.activities.AboutActivity;
import com.crom.about.R;
import com.crom.about.Utils;

public class AboutFragments extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

        View aboutView = inflater.inflate(R.layout.about_fragment, container, false);

        TextView aboutTitle = (TextView) aboutView.findViewById(R.id.about_title);
        aboutTitle.append(" C-RoM ");

        TextView aboutText = (TextView) aboutView.findViewById(R.id.about);
        aboutText.setText(Utils.readRawFile(AboutActivity.appContext, R.raw.about_crom));

        Button btnDonate = (Button) aboutView.findViewById(R.id.btn_donate);
        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri donateURL = Uri.parse("http://forum.xda-developers.com/donatetome.php?u=4336480");
                final Intent donIntent = new Intent(Intent.ACTION_VIEW, donateURL);
                donIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(donIntent);
            }
        });

        Button btnWebsite = (Button) aboutView.findViewById(R.id.btn_website);
        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webURL = Uri.parse("http://c-rom.org");
                final Intent webIntent = new Intent(Intent.ACTION_VIEW, webURL);
                webIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(webIntent);
            }
        });



        return aboutView;
    }
}
