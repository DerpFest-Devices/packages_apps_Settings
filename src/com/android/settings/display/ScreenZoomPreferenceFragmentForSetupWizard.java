/*
 * Copyright (C) 2016 The Android Open Source Project
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

package com.android.settings.display;

import android.app.settings.SettingsEnums;

import com.android.settings.R;

public class ScreenZoomPreferenceFragmentForSetupWizard extends ScreenZoomSettings {

    @Override
    protected int getActivityLayoutResId() {
        return R.layout.suw_screen_zoom_fragment;
    }

    @Override
    public int getMetricsCategory() {
        return SettingsEnums.SUW_ACCESSIBILITY_DISPLAY_SIZE;
    }

    @Override
    public void onStop() {
        // Log the final choice in value if it's different from the previous value.
        if (mCurrentIndex != mInitialIndex) {
            mMetricsFeatureProvider.action(
                    getContext(), SettingsEnums.SUW_ACCESSIBILITY_DISPLAY_SIZE, mCurrentIndex);
        }

        super.onStop();
    }
}

