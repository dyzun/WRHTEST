//
// Copyright 2016 Amazon.com, Inc. or its affiliates (Amazon). All Rights Reserved.
//
// Code generated by AWS Mobile Hub. Amazon gives unlimited permission to 
// copy, distribute and modify it.
//
// Source code generated from template: aws-my-sample-app-android v0.8
//
package com.amazonaws.mobile;

import com.amazonaws.regions.Regions;

/**
 * This class defines constants for the developer's resource
 * identifiers and API keys. This configuration should not
 * be shared or posted to any public source code repository.
 */
public class AWSConfiguration {

    // AWS MobileHub user agent string
    public static final String AWS_MOBILEHUB_USER_AGENT =
        "MobileHub fe7f7e3b-82a4-4161-8b28-a86f50816589 aws-my-sample-app-android-v0.8";
    public static final Regions AMAZON_DEFAULT_REGION = Regions.US_EAST_1;

    // AMAZON COGNITO
    public static final Regions AMAZON_COGNITO_REGION =
      Regions.fromName("us-east-1");
    public static final String  AMAZON_COGNITO_IDENTITY_POOL_ID =
        "us-east-1:a4e9a1cf-508d-4949-a930-fb7f34f2b1e1";
    // AMAZON MOBILE ANALYTICS
    public static final String  AMAZON_MOBILE_ANALYTICS_APP_ID =
        "b1e9b3097777451a8c944493338b9e54";
    // Amazon Mobile Analytics region
    public static final Regions AMAZON_MOBILE_ANALYTICS_REGION = Regions.US_EAST_1;
    public static final String AMAZON_CONTENT_DELIVERY_S3_BUCKET =
        "wearehenry-contentdelivery-mobilehub-2003333601";
    public static final Regions AMAZON_CONTENT_DELIVERY_S3_REGION =
       Regions.fromName("us-east-1");
    public static final String AMAZON_CLOUD_FRONT_DISTRIBUTION_DOMAIN =
        "d3twfzxl5ihg7a.cloudfront.net";
    // S3 BUCKET
    public static final String AMAZON_S3_USER_FILES_BUCKET =
        "wearehenry-userfiles-mobilehub-2003333601";
    // S3 BUCKET REGION
    public static final Regions AMAZON_S3_USER_FILES_BUCKET_REGION =
        Regions.fromName("us-east-1");
    public static final Regions AMAZON_DYNAMODB_REGION =
       Regions.fromName("us-east-1");
}