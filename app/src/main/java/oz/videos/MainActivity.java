package oz.videos;


import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;

import at.huber.youtubeExtractor.YouTubeUriExtractor;
import at.huber.youtubeExtractor.YtFile;

public class MainActivity extends Activity
{

    private static String youtubeLink;

    //private LinearLayout mainLayout;
    //private ProgressBar mainProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youtubeLink = "http://youtube.com/watch?v=uIDJa3bdfh4";

        YouTubeUriExtractor ytEx = new YouTubeUriExtractor(this)
        {
            @Override
            public void onUrisAvailable(String videoId, String videoTitle, SparseArray<YtFile> ytFiles)
            {
                if (ytFiles != null) {
                    int itag = 22;
                    // Here you can get download url
                    String downloadUrl = ytFiles.get(itag).getUrl();
                }
            }
        };
        ytEx.execute(youtubeLink);
    }
}
