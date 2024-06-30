function getRootPath() {
    // 获取当前页面路径：http://localhost:8160/learn/hello.jsp
    let currentPath = window.location.href;
    // 获取主机地址之后的项目路径：/learn/hello.jsp
    let pathName = window.location.pathname;
    // 获取主机地址：http://localhost:8160
    let localhostPath = currentPath.substring(0, currentPath.indexOf(pathName));
    // substr(start, number)：截取字符串，start开始，number个字符，number可选，已废弃
    // let projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    // slice()与substring()均算头不算尾
    // slice(start, end)：截取字符串，start开始，end结束，end值为截取结束位置下标+1
    // slice(end)：若end为负数，则从对应的倒数第end绝对值个元素到最后一个字符，包含最后一个字符
    // let projectName = pathName.substring(0, pathName.slice(1, pathName.length + 1).indexOf('/') + 1);
    // substring(from, to)：截取字符串，from开始，to结束，均为非负整数，end值为截取结束位置下标+1，end可选
    // indexOf(str)：返回某个指定的字符串在字符串中首次出现的位置，如果没有找到匹配的字符串则返回-1
    // 获取项目项目名：/learn
    let projectName = pathName.substring(0, pathName.substring(1).indexOf('/') + 1);
    return localhostPath + projectName;
}
