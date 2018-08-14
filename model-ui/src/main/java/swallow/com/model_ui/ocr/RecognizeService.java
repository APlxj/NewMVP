package swallow.com.model_ui.ocr;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.GeneralParams;
import com.baidu.ocr.sdk.model.GeneralResult;
import com.google.gson.Gson;

import java.io.File;

public class RecognizeService<T> {
    private static Gson gson;

    public interface ServiceListener<T> {
        void onResult(T result);

        void onError(String result);
    }

    public static void recAccurateBasic(String filePath, final ServiceListener<ResultOcrModel> listener) {
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
                ResultOcrModel resultModel = gson.fromJson(result.getJsonRes(), ResultOcrModel.class);
                listener.onResult(resultModel);
            }

            @Override
            public void onError(OCRError error) {
                listener.onError(error.getMessage());
            }
        });
    }
}
