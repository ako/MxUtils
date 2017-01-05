# Mendix Utils Microflow actions

## Date time conversions

* Convert Long containing unix epoch to DateTime.

## Lists

* Generate List of Longs

* Generate list of Dates

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

* Templating engine

 [1]: docs/images/mf_aws_rekognition_labels_image.png
 [2]: docs/images/mf_aws_rekognition_detect_faces.png
 [3]: docs/images/mf_copy_file_document_to_s3.png