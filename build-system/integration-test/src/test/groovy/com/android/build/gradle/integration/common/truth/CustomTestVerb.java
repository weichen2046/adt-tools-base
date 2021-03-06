/*
 * Copyright (C) 2015 The Android Open Source Project
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

package com.android.build.gradle.integration.common.truth;

import com.android.annotations.Nullable;
import com.android.builder.model.SyncIssue;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.TestVerb;

import java.io.File;

/**
 * Convenience class to extend the functionality of {@link TestVerb} for custom Subject;
 */
public class CustomTestVerb extends TestVerb {
    public CustomTestVerb(FailureStrategy failureStrategy) {
        super(failureStrategy);
    }

    public CustomTestVerb(FailureStrategy failureStrategy, String failureMessage) {
        super(failureStrategy, failureMessage);
    }

    public FileSubject that(@Nullable File target) {
        return FileSubject.FACTORY.getSubject(getFailureStrategy(), target);
    }

    public IssueSubject that(@Nullable SyncIssue target) {
        return new IssueSubject(getFailureStrategy(), target);
    }
}
