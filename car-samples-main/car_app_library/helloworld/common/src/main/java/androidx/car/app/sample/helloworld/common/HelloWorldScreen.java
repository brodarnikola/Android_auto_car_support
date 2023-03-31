/*
 * Copyright (C) 2021 The Android Open Source Project
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
package androidx.car.app.sample.helloworld.common;

import static androidx.car.app.CarToast.LENGTH_SHORT;
import static androidx.car.app.model.Action.BACK;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.car.app.CarContext;
import androidx.car.app.CarToast;
import androidx.car.app.Screen;
import androidx.car.app.model.Action;
import androidx.car.app.model.ActionStrip;
import androidx.car.app.model.CarColor;
import androidx.car.app.model.CarIcon;
import androidx.car.app.model.ItemList;
import androidx.car.app.model.ListTemplate;
import androidx.car.app.model.Pane;
import androidx.car.app.model.PaneTemplate;
import androidx.car.app.model.Row;
import androidx.car.app.model.SectionedItemList;
import androidx.car.app.model.Template;
import androidx.core.graphics.drawable.IconCompat;

/**
 * A screen that shows a simple "Hello World!" message.
 *
 * <p>See {@link HelloWorldService} for the app's entry point to the car host.
 */
public class HelloWorldScreen extends Screen {
    public HelloWorldScreen(@NonNull CarContext carContext) {
        super(carContext);

    }


    @Nullable
    private IconCompat mCommuteIcon;


    @NonNull
    @Override
    public Template onGetTemplate() {

        mCommuteIcon = IconCompat.createWithResource(getCarContext(), R.drawable.ic_baseline_add_alert_24);

        Row row = new Row.Builder().setTitle("Hello AndroidX! This is awesome 6")
////                .setOnClickListener(
////                        () -> {
////                            this.getCarContext().startActivity(new Intent(Intent.ACTION_VOICE_COMMAND).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
////                        }
////                )
               .build();

//
//        ListTemplate.Builder templateBuilder = new ListTemplate.Builder();
//
//        // The Image to be displayed in a row
//        Resources resources = getCarContext().getResources();
////        Bitmap bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_baseline_add_alert_24);
////        IconCompat mImage = IconCompat.createWithBitmap(bitmap);
//
//        ItemList radioList =
//                new ItemList.Builder()
//                        .addItem(new Row.Builder()
//                                .setTitle("Awesome")
//                                .addText("Awesome")
//                                // .setEnabled(true)
//                                .build())
//                        .addItem(new Row.Builder()
////                                .setImage(
////                                        new CarIcon.Builder(
////                                                IconCompat.createWithResource(
////                                                        getCarContext(),
////                                                        R.drawable
////                                                                .ic_fastfood_white_48dp))
////                                                .build(),
////                                        Row.IMAGE_TYPE_ICON)
//                                .setTitle("Awesome")
//                                .addText("Awesome")
//                                // .setEnabled(true)
//                                .build())
//                        .addItem(new Row.Builder()
////                                .setImage(
////                                        new CarIcon.Builder(mImage).build(),
////                                        Row.IMAGE_TYPE_LARGE)
//                                .setTitle("Awesome")
//                                .addText("Awesome")
//                                // .setEnabled(true)
//                                .build())
//                        // .setOnSelectedListener( )
//                        .build();
//        templateBuilder.addSectionedList(
//                SectionedItemList.create(radioList,
//                        "Awesome"));
//
//        templateBuilder
//                .setTitle("Awesome")
//                .setActionStrip(
//                        new ActionStrip.Builder()
//                                .addAction(
//                                        new Action.Builder()
//                                                .setTitle("Awesome")
//                                                .setOnClickListener(
//                                                        () -> {
//                                                        })
//                                                .build())
//                                .build())
//                .setHeaderAction(
//                        BACK).build();

        return new PaneTemplate.Builder(new Pane.Builder().build())
                .setHeaderAction(Action.APP_ICON)
                .setActionStrip(
                        new ActionStrip.Builder()
                                .addAction(new Action.Builder()
                                        .setTitle("Commute")
                                        .setIcon(
                                                new CarIcon.Builder(mCommuteIcon)
                                                        .setTint(CarColor.BLUE)
                                                        .build())
                                        .setOnClickListener(
                                                () -> CarToast.makeText(
                                                                getCarContext(),
                                                                "Clicked",
                                                                LENGTH_SHORT)
                                                        .show())
                                        .build())
                                .build())
                .setTitle("awesome app")
                .build();

//        return new PaneTemplate.Builder(new Pane.Builder().addRow(row).build())
//                .setHeaderAction(Action.APP_ICON)
//                .build();
    }
}
