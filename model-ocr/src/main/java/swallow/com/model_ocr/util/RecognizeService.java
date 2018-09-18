package swallow.com.model_ocr.util;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.GeneralParams;
import com.baidu.ocr.sdk.model.GeneralResult;
import com.google.gson.Gson;

import java.io.File;

import swallow.com.model_ocr.model.ResultModel;

public class RecognizeService<T> {
    private static Gson gson;

    public interface ServiceListener<T> {
        void onResult(T result);

        void onError(String result);
    }

    public static void recAccurateBasic(String filePath, final ServiceListener<ResultModel> listener) {
        GeneralParams param = new GeneralParams();
        param.setDetectDirection(true);
        param.setVertexesLocation(true);
        param.setRecognizeGranularity(GeneralParams.GRANULARITY_SMALL);
        param.setImageFile(new File(filePath));
        OCR.getInstance().recognizeAccurateBasic(param, new OnResultListener<GeneralResult>() {
            @Override
            public void onResult(GeneralResult result) {
                if (gson == null) {
                    gson = new Gson();
                }
                ResultModel resultModel = gson.fromJson(result.getJsonRes(), ResultModel.class);
                listener.onResult(resultModel);
            }

            @Override
            public void onError(OCRError error) {
                listener.onError(error.getMessage());
            }
        });
    }
}
