package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.s3.event.S3EventNotification;

import java.util.List;

public class Hello
{
    public String myHandler(S3EventNotification request, Context context)
    {
        List<S3EventNotification.S3EventNotificationRecord> records = request.getRecords();
        S3EventNotification.S3EventNotificationRecord record = records.get(0);
        String bucketName = record.getS3().getBucket().getName();
        LambdaLogger logger = context.getLogger();
        logger.log("received bucket : " + bucketName);
        return bucketName;
    }
}
