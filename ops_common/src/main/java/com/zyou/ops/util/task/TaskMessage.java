package com.zyou.ops.util.task;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.util.task
 * @Author: yang
 * @CreateTime: 2019-05-20 09:23
 * @Description: ${Description}
 */
public class TaskMessage {

    public void init(){
        List<UserTask> SmailTaskList=new ArrayList<>();
        UserTask t1=new UserTask("生活习惯","不偏食、挑食、暴饮暴食【均适用】","请家长引导孩子独立用勺子吃晚餐，可适当玩一些小游戏帮助孩子进餐，如小飞机送餐（勺子当飞机，将饮食送进宝宝嘴里）;尝味道（家长引导：如我要吃红萝卜，脆脆的甜甜的，孩子：我也要吃红萝卜，脆脆的甜甜的等等）。");
        UserTask t2=new UserTask("生活习惯","愿意按时吃饭","请家长按照家里的饮食时间，及时引导幼儿，摆碗筷（帮助把碗筷摆整齐，几人吃饭摆几副碗筷）。");
        UserTask t3=new UserTask("生活习惯","饭前便后洗手，擦干手，饭后漱口，擦嘴巴","请家长引导孩子饭前洗手，并了解洗手的基本步骤（挽袖子、开水龙头，湿手、关水龙头、抹肥皂或洗手液、搓手、打开水龙头洗手、关水，用擦手。）吃完后在家长的帮助下进行漱口，并引导幼儿掌握基本的漱口方法，漱口后擦嘴巴。");
        UserTask t4=new UserTask("生活习惯","保持桌面整洁、干净卫生","请家长引导孩子吃饭时细嚼慢咽，尽量不洒落饭粒或菜品在桌上。可适当带上围兜，每次吃完饭后看看围兜里是否有掉落，以此监督并鼓励幼儿，吃饭时一只手扶碗，一只手拿汤匙或筷子。");
        UserTask t5=new UserTask("生活习惯","专心吃饭，安静进餐，不边吃边玩","安静进餐（关掉电视，放下手机，吃饭前可以引导孩子报菜名，家长简单介绍菜的营养价值，吃了会长高长漂亮等等）。");
        UserTask t6=new UserTask("生活习惯","愿意饮用白开水，不贪喝饮料","及时提醒孩子饮用白开水，可使用儿歌或游戏的形式：拿起小水杯，接杯白开水。坐下慢慢喝，多喝水，不生病，咕嘟咕嘟喝进嘴！");
        UserTask t7=new UserTask("生活习惯","在家长的引导下，知道不要在运动后立即大量饮水","请家长提醒孩子运动后，不立即大量饮水；可以带着孩子阅读绘本《来喝水吧》，了解喝水的重要性，也可以通过观看爱奇艺视频《多喝开水好处多》。");
        UserTask t8=new UserTask("生活习惯","在家长的引导下，适量饮水","请家长主动询问孩子是否需要饮水，并和孩子适当饮水，补充水分。");
        UserTask t9=new UserTask("生活习惯","睡前保持心情平静，不大吵大闹。","家长在宝宝入睡前读绘本或者讲故事，如《小猪盖房子》《月亮婆婆》《三只小熊》《聪明的小羊》《小老鼠的魔法书》《你醒了吗？》《好困好困的蛇》《不睡觉世界冠军》等，让孩子情绪平稳，有良好的入睡前准备。-均适用");
        UserTask t10=new UserTask("生活习惯","在家长引导下，能按时睡前洗漱，脱换衣物，摆放整齐。","家长可引导幼儿按时进行洗漱，换上睡衣等。了解脱衣服的顺序：先脱鞋，再脱裤，最后脱衣服，并把衣服摆放整齐。");
        UserTask t11=new UserTask("生活习惯","能在安静的睡眠环境下，快速入睡。","在宝贝入睡时，盖好被子，不趴着睡觉，保持良好的睡姿。");
        UserTask t12=new UserTask("生活习惯","在引导下初步掌握七步洗手法","观看《宝宝爱洗手》视频，初步了解七步洗手法。-均适用");
        UserTask t13=new UserTask("生活习惯","在引导下做到饭前便后要洗手，擦手","孩子在家时，提醒并协助孩子进行饭前便后洗手，擦手。");
        UserTask t14=new UserTask("生活习惯","在引导下餐后漱口擦嘴","协助孩子进行洗漱，餐后漱口擦嘴，并让宝宝自己涂抹香香");
        UserTask t15=new UserTask("生活习惯","在引导下早晚知道要刷牙","引导孩子早晚记得刷牙，并初步掌握刷牙的基本方法，可辅以儿歌：小牙刷，手中拿，我呀张开小嘴巴， 刷左边，刷右边，上下里外都刷刷， 早上刷，晚上刷，刷得牙齿没蛀牙， 张张口，笑一笑，我的牙齿刷得白花花");
        UserTask t16=new UserTask("生活习惯","在引导下知道餐后漱口擦嘴","在家吃早、中饭后，爸爸妈妈要提醒孩子饭后漱口。-均适用 亲子游戏：咕咚咕咚！ 准备3个纸杯【或者3个水杯】以及一盒纸巾，父母跟宝贝人手一个。念儿歌：一起漱漱口，咕咚咕咚噗，细菌全都跑光光；一起漱漱口，咕咚咕咚噗，小嘴干净又健康；小纸巾拿起来，擦擦嘴巴 真干净！");
        UserTask t17=new UserTask("生活习惯","渐渐学会自理大小便，避免大小便在衣裤上和将大小便弄到便池外。","在大小便时，能够自己尝试脱裤子；小女生小便后正确使用纸巾从前往后擦私处。");
        UserTask t18=new UserTask("生活习惯","在提醒下便后记得冲水、洗手、擦手。","上完厕所后，父母进行示范榜样冲水、洗手。可以给孩子配专用的洗手液【洗手皂】，让孩子形成物品秩序感。");
        UserTask t19=new UserTask("生活习惯","能够用简单语言表达出如厕的需求和遇到问题","亲子阅读/视频观看，绘本《皮皮放屁屁》《小米的便便商店》《呀！屁股》等书籍教育引导，一起分享自己的感受和想法。【如果如厕时发生些意外小状况，不要去责怪。要鼓励孩子敢于尝试，并告诉孩子每次妈妈都会陪着你，下次一定会做得更好】");





    }
}
