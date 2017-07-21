package com.syh.epoch.ec.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * Created by 孙应恒 on 2017/7/21.
 * Description:  导入阿里巴巴矢量图标库  http://www.iconfont.cn
 *              \epoch-ec\src\main\assets\iconfont.ttf
 */

public class FontEcModule implements IconFontDescriptor{
  @Override
  public String ttfFileName() {
    return "iconfont.ttf";
  }

  @Override
  public Icon[] characters() {
    return EcIcons.values();
  }
}
