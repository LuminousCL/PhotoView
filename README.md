![Version](https://img.shields.io/badge/version-2.0.1-blue)
![Version](https://img.shields.io/badge/milestones-2-brightgreen)
![Version](https://img.shields.io/badge/cooperation-Tecent-red)

# PhotoView


**PhotoView:** 在线图片的加载DEMO

**格式布局:** 4 * N

**功能:** ADD: 加载图片；CLEAR: 删除现有显示图片

**预览:** 
<img src="imgs/1.png" width="50%" height="50%">


**PhotoView组成部分：** 

**1. activity_main.xml** 用来设计图片加载demo的基本布局：

<img src="imgs/2.png" width="50%" height="50%">

每页显示24个item，设置有两个按键：ADD和CLEAR；



**2.photo_layout_xml:**

<img src="imgs/3.png" width="50%" height="50%">


**3.AndroidManifest.xml:**

<img src="imgs/4.png" width="50%" height="50%">



**4.MainActivity.java:**

<img src="imgs/5.png" width="50%" height="50%">



**5.PhotoViewAdapter.java:**

<img src="imgs/6.png" width="50%" height="50%">


**在线加载图片工具：** `DownloadImageListUtil`, `DiskLruCacheUtil`, `mageLoader`
 
