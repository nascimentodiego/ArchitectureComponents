/*
 * Copyright 2017 Diego Nascimento.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.dfn.androidcomponent.architecturecomponents.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.dfn.androidcomponent.architecturecomponents.R;
import br.com.dfn.androidcomponent.architecturecomponents.model.Films;

public class FilmsAdapter extends ArrayAdapter<Films.Film> {

    public FilmsAdapter(@NonNull Context context, @NonNull List<Films.Film> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Films.Film obj = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item, parent, false);
        }

        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);

        txtTitle.setText(obj.title);

        return convertView;
    }
}
