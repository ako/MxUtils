# Mendix Utils Microflow actions

This project contains a number of Mendix connectors:

* [Lists](#lists)
* [AWS S3](#aws-s3)
* [AWS Rekognition](#aws-rekognition)
* [Mustache](#mustache)
* [Google Analytics](#google-analytics)


## Lists

* Generate List of Longs

 ![Generate long series][4]

* Generate list of Dates

 ![Generate every four weeks series][5]

## AWS S3

* Copy File document to S3

The following example generates a file document using a markdown template. 
Then the filedocument is copied to s3.
 
 ![Copy file document to S3][3]

## AWS Rekognition

* LabelImage - return list of things recognized in image on s3

 ![Determine labels for objects in image][1]
 
* Detect Faces - detect faces in image on s3
 
 ![Determine face details and emotions for people in image][2]
 
## Mustache

* Templating engine with support for markdown:

 ![Mustache markdown template][6]
 
## Google Analytics

The Google Analytics connector enables you to send measurement events to Google Analytics from your Microflows.

 ![Google Analytics toolbox][10]
 
There are 3 actions you can use:

* Track PageView - Can be used to register a pageview by the user, instead of using a widget on your page.
* Track Event - Track any event in your microflow.
* Track Exception - Track exceptions in your microflows.

More info on using Google Analytics measurements api can be found here: [Measurement Protocol Overview][9]

 ![Google Analytics track event example][8]

## Development

The sourcecode for these Connectors can be found on Github: [Mendix MxUtils][7]

All java jar dependencies are managed using an ivy file. You can download all
dependencies by running runivy.cmd. This will save all jars in the userlib folder. There are two different
scripts to run ivy:
* runivy.cmd - downloads all dependencies required for running and testing the project
* runivy-export.cmd - downloads only the dependencies required for distributing the connector mpk.

Before you start to develop the connector you need to run runivy.cmd. After you validate everything works, run runivy-export.cmd.
This will delete all jars in the userlib folder and only download the jars required for creating the connector mpk.


 [1]: docs/images/mf_aws_rekognition_labels_image.png
 [2]: docs/images/mf_aws_rekognition_detect_faces.PNG
 [3]: docs/images/mf_copy_file_document_to_s3.png
 [4]: docs/images/mf_generate_long_series.png
 [5]: docs/images/mf_generate_every_4_weeks_series.png
 [6]: docs/images/mf_mustache_markdown_template.png
 [7]: https://github.com/ako/MxUtils
 [8]: docs/images/ga_track_event_example.png
 [9]: https://developers.google.com/analytics/devguides/collection/protocol/v1/
 [10]: docs/images/google_analytics_toolbox.png

