package com.example.photoswalldemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.GridView;

import com.example.photoswalldemo.R;
import com.example.photoswalldemo.adapter.PhotoViewAdapter;
import com.example.photoswalldemo.utility.ImageSource;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

	private static String url;
	private static int page = 0;

	/**
	 * PhotoWall Display GridView
	 */
	private GridView mPhotoWallView;

	/**
	 * GridView Adapter
	 */
	private PhotoViewAdapter mWallAdapter;

	private int mImageThumbSize;
	private int mImageThumbSpacing;

	private List<String> mImageUrlList = new ArrayList<>();
	private ImageSource imageSource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		initView();
		initEvent();
		initData();
	}

	public void initView() {
		setContentView(R.layout.activity_main);
		mPhotoWallView = (GridView) findViewById(R.id.photo_wall);
	}

	public void initEvent() {
		mImageThumbSize = getResources().getDimensionPixelSize(R.dimen.image_thumbnail_size);
		mImageThumbSpacing = getResources().getDimensionPixelSize(R.dimen.image_thumbnail_spacing);
		//Monitor the width and height of the picture
		mPhotoWallView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

			@Override
			public void onGlobalLayout() {
				// Calculate column
				final int numColumns = (int) Math.floor(mPhotoWallView.getWidth() / (mImageThumbSize + mImageThumbSpacing));
				if (numColumns > 0) {
					int columnWidth = (mPhotoWallView.getWidth() / numColumns) - mImageThumbSpacing;
					mWallAdapter.setItemSize(columnWidth);
					mPhotoWallView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
				}
			}
		});
	}

	public void initData() {


		if (mWallAdapter == null) {
			mWallAdapter = new PhotoViewAdapter(this, mImageUrlList, mPhotoWallView);
		}
		mPhotoWallView.setAdapter(mWallAdapter);
		imageSource = new ImageSource();
	}

	public void add(View view) {

		mImageUrlList.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1297016213,3186274697&fm=26&gp=0.jpg");
		mImageUrlList.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2996532642,3754404216&fm=26&gp=0.jpg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589684312447&di=58e42b133f940f0f6bc2400a98c8d797&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201411%2F01%2F20141101213318_hdUjC.thumb.700_0.jpeg");
		mImageUrlList.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=943786687,2405838224&fm=26&gp=0.jpg");
		mImageUrlList.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=238082593,492510871&fm=26&gp=0.jpg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589684383113&di=a876c7a76d03f9cb10103b9dc7d56f18&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201602%2F09%2F20160209011637_VwcHJ.thumb.700_0.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589684388178&di=7c502a717d8db9e0a114253c361f9d92&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201505%2F09%2F20150509113203_wdEWv.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589684460447&di=a75746302952d7caba910fdaa2702876&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201507%2F30%2F20150730230906_TVSC8.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589684391842&di=4a2e89bdaeb6af56e624ad251b2da379&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201509%2F16%2F20150916205648_Q4Sna.thumb.700_0.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589684398276&di=08407c78174dfc7f2e62195e05c39bd4&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201711%2F19%2F20171119144234_5eMk3.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589684400802&di=619b56ab219906fef9ded03133a466a4&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201502%2F14%2F20150214004227_nkG8h.thumb.700_0.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589684404411&di=50e1442aed9fde116e15b9ede1a9b497&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201407%2F18%2F20140718184226_VHNcS.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589684406463&di=6a1095346571816687151004a6948591&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201603%2F30%2F20160330080855_FXrsY.jpeg");
		mImageUrlList.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2611479547,1817727826&fm=26&gp=0.jpg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589684638748&di=c417f3fbc93fa85a9a30574b5cf0a844&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201902%2F11%2F20190211150226_KXTBx.thumb.700_0.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589684660242&di=4fbdc2d3c41c231eb16dfc3a6d1b97db&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201508%2F04%2F20150804212113_3iQE5.jpeg");
		mImageUrlList.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2206816678,2213937581&fm=26&gp=0.jpg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589684581549&di=146e82062cb4d1e413ba11efb02abd1d&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201606%2F23%2F20160623115449_mfwdF.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589684707277&di=6f5c2fc17e50cf2bd30768f053e0f274&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2F4738c034527bdc2314e13f8173922f3f5be7c0b3.jpg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589684798823&di=6d8be33484a7cea002590c8c0d7e9cda&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201801%2F25%2F20180125104443_QLhhr.thumb.700_0.jpeg");

		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589685166148&di=7174243b4eaa578c150e5301fe8f6290&imgtype=0&src=http%3A%2F%2Fa-ssl.duitang.com%2Fuploads%2Fitem%2F201411%2F01%2F20141101213424_VhRc5.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589685138789&di=9981ab6c5a37ad0ce45f5fa155455b2b&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201510%2F16%2F20151016191428_t2Lxf.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589685131582&di=cdb9840e4629ae1b1c764252866f9037&imgtype=0&src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201511%2F06%2F20151106110327_HTRCu.jpeg");
		mImageUrlList.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2875919949,85835260&fm=26&gp=0.jpg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589685097571&di=4266eea049ac019952e357dce2daf6f0&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201608%2F27%2F20160827200707_tzHnC.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589685086329&di=69efb66a5fb19bbd397c15cea333b85a&imgtype=0&src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F201509%2F16%2F20150916205603_YdMCm.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589685076048&di=0113ffb7aef043ece7cbf73bd116d798&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201502%2F04%2F20150204232929_tKcHX.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589685413029&di=8e962aa473cf23941799e3fd7a84294a&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201711%2F25%2F20171125143422_iCTEh.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589685419221&di=91fa523d98ee0fee73b6e1ad9b89caad&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201902%2F11%2F20190211115538_ncXzE.thumb.700_0.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589685436267&di=55aa3e1b0a75468bcb20f5da9e6eee9f&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201801%2F25%2F20180125173745_4VvrB.jpeg");
		mImageUrlList.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1840007409,2869476978&fm=26&gp=0.jpg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589685539612&di=9e0cf1b6ac589070c45f0a355f801019&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201802%2F16%2F20180216125545_taRtm.thumb.700_0.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589685542263&di=28f06428fd2b36cb3f6d7ab77b020077&imgtype=0&src=http%3A%2F%2Fzkres2.myzaker.com%2F202005%2F5ebdf5b78e9f096915541886_1024.jpg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589685525570&di=067479a63ba82f88d97bfb8fad564ec3&imgtype=0&src=http%3A%2F%2Fc3.haibao.cn%2Fimg%2F600_0_100_1%2F1445490315.5838%2Fa168d2a5262b76784490e4caf54a1d10.jpg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589685638168&di=011479bfb75c28b69844cd136b1fc22f&imgtype=0&src=http%3A%2F%2Fimg1.c.yinyuetai.com%2Fuploads%2FPrcMhjnEg1.jpg%3Fsize%3D220x220");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589685629733&di=1096bcb176f5395e4584db289996b662&imgtype=0&src=http%3A%2F%2Fc3.haibao.cn%2Fimg%2F0_0_100_0%2F1445490231.826%2Fb5cf8a096956a4a03845e9e3934a7acf.jpg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589685642915&di=98ad7eed56e002672a1bf1d4f2d93a71&imgtype=0&src=http%3A%2F%2Fqimg.hxnews.com%2F2017%2F0801%2F1501553209908.jpg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589687108744&di=d2ec7b2802e9a26609692890e3674dc7&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201712%2F07%2F20171207164850_f8Zwj.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589685803382&di=dc55bba573ab57f92a1a4a3013ce553e&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F30%2F20160730133013_3jasm.jpeg");
		mImageUrlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589685784604&di=2ca67bc09d4c42214b9d585e03b6fa0f&imgtype=0&src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201510%2F13%2F20151013235805_4WGhE.jpeg");

		//initData();
		mWallAdapter.notifyDataSetChanged();
	}

	public void clear(View view) {
		mImageUrlList.clear();
		mWallAdapter.notifyDataSetChanged();
	}


	@Override
	protected void onPause() {
		super.onPause();
		mWallAdapter.mImageLoader.flushCache();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// End all download tasks when exiting the program
		mWallAdapter.mImageLoader.cancelAllTasks();
		mWallAdapter.mImageLoader.deleteCache();
	}
}