
controller 层

@ResponseBody表示只返回字符串,如果函数返回对象为ModelAndView就要报错.
如果没有@ResponseBody,返回字符串,得到的结果为字符串对应的视图.