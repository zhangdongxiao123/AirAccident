package com.example.airaccident.Other.PicInfo.Bean;

import com.example.airaccident.R;

import java.util.ArrayList;
import java.util.List;

public class AirUtils {
    private static final String[] title={"河北空管分局成功处置一起航班落地后故障的不正常情况",
           " 外籍男子强行爬上飞机起落架，航班延误超2小时","法航北京飞巴黎波音客机起飞后挂7700代码！紧急返航已落地",
            "日本一直升机实施救援时发生失误 致一女性高空坠落","嫌机舱太闷，大妈打开飞机安全门！厦航：已被警方带走",
            "右起落架冒烟 载300余人客机在俄硬着陆 49人受伤","川航南京飞成都空客深夜遭遇鸟击返航！盘旋后落地将安排补班飞机",
            "一航班客舱内旅客充电宝自燃，东航：为确保安全已返航南京","俄航飞北京航班在莫斯科机场跑道发生撞机,无人受伤",
            "海航客机滑行时客舱疑似出现烟雾 更换飞机执飞","首都机场一架客机货仓冒烟 机上无乘客",
            "大家伙占跑道 民航马不停蹄搬飞机","南昌机场故障飞机已被搬移 跑道适航提前开放",
            "747货机跑道趴窝，南昌机场陷落，这架小飞机上演火线救援！","突发，上海虹桥机场一公务机冲出跑道，无人员受伤",
            "一架从中国三亚起飞的客机紧急迫降哈首都国际机场，机上人员全部安全","机舱冒烟英航一客机紧急着陆 机上约20名乘客受伤",
            "福州机场SUV穿越滑行道险撞飞机！专业人士：车辆避让飞机是常识","焦点对话：监督员大闹航班 精神病患乘机该怎么管？",
            "上航通报航班氧气面罩脱落:发现故障提示 按程序释放","香港机场工程车起火险波及港航客机 幸无人受伤",
            "北京飞往圣彼得堡空客飞机出故障 已成功着陆","南航A380遭遇冰雹风挡破裂，权威回应来了",
            "平安降落！南航一飞机遭冰雹致挡风玻璃破裂"
    };
    private static final int[] resId ={R.mipmap.hangkong1,R.mipmap.hangkong2,R.mipmap.hangkong3, R.mipmap.hangkong4,
            R.mipmap.hangkong5,R.mipmap.hangkong6,R.mipmap.hangkong7,R.mipmap.hangkong8,
            R.mipmap.hangkong9,R.mipmap.hangkong10,R.mipmap.hangkong11,R.mipmap.hangkong12,
            R.mipmap.hangkong13, R.mipmap.hangkong14,R.mipmap.hangkong15,R.mipmap.hangkong16,
            R.mipmap.hangkong17,R.mipmap.hangkong18, R.mipmap.hangkong19,R.mipmap.hangkong20,
            R.mipmap.hangkong21,R.mipmap.hangkong22,R.mipmap.hangkong23, R.mipmap.hangkong24
    };
    private static final String[] jianjie={
            "2019年11月2日，由广州飞抵石家庄的CSN6540航班于19:51落地后，在地面滑行时，机组报告飞机前轮故障无法滑行，需要立即处置。河北空管分局全力保障、成功处置了故障航班CSN6540在石家庄机场落地后因前轮故障造成跑道占用，并保证了后续航班安全顺畅运行。当时，CSN6540航班使用33号跑道落地后，在跑道A3道口前停住，塔台管制员指挥其沿A3脱离，机组报告飞机前轮可能故障了，无法滑行，需要消防救援等。管制员立刻通知消防部门、现场指挥中心等相关单位，并按照特情处置检查单进行处置。由于跑道被占用，拖行方案尚未确定，造成飞机脱离时间不确定。19:57分，消防与场务等部门进入跑道处置，机务报告需要等南航公司的拖行方案。21:31分，机务人员报告飞机可以拖行，21:37开始拖行飞机，21:51飞机拖至203号机位。21:55分，场务部门报告跑道经检查正常可用，恢复了正常运行。在此期间，机场机务提交拍发跑道占用通告，时间段为20:37-21:35。21:05左右，飞行服务室管制员考虑到通告时间即将到期，提前询问相关部门是否需要继续拍发跑道占用通告，进近管制室通知空中进场航班至21:35分后再进场，可能会导致盘旋等待的飞机飞往备降场时有油量紧张的风险、后续进港航班造成积压等情况。值班人员为避免预判情况的发生，积极询问有关情况、续发航行通告等。在大家共同努力下，全力保障了空中、地面航班的运行安全、有序。"
            ,"台湾桃园机场2日发生匪夷所思一幕。据台媒报道，台湾中华航空CI-28班机2日下午正准备起飞时，一白人男子突然从一旁草丛中窜出，还爬上了该班机起落架。台媒报道称，排在该飞机后排的韩亚航空机长见此情景“看傻了”，随后立即通报，机场塔台方面先是“诧异”，经机长反复解释后，要求出事航班暂停起飞，工作人员与机场警方也迅速赶到制服该男子。"
            ,"10月25日上午，一架法国航空从北京飞往巴黎的波音777客机，在起飞后挂出7700代码，随后空中盘旋放油后返航北京，目前已经在25日12时04分落地北京首都国际机场。南都记者查询“飞常准”获悉，涉事航班为法航AF125航班，于10月25日9时36分从北京首都国际机场起飞，原计划飞行13小时抵达法国巴黎戴高乐机场，飞行里程8185公里，航班执飞机型为波音777-300ER，机龄12.3年。航班动态显示，该架航班实际在25日12时返航落地北京，目前返航原因尚未公布。据公开资料显示，飞行员在飞行过程中，遇到特殊情况，会将应答代号设置为特殊代码。其中7700代码表示遇到紧急状况，例如机械故障或有机上人员突发疾病等，但并非一定表示飞机处于非常危险的状况。（来源：腾讯网）"
            ,"据日本共同社报道，日本东京消防厅透露，13日在福岛县磐城市实施的台风“海贝思”救援行动中出现失误，导致一名70多岁女性从消防直升机向下坠落约40米。据称，该女性处于心肺功能停止状态，被送往医院。台风“海贝思”12日从日本静冈县登陆后，强风暴雨酿成严重灾害，日本多地河川水位暴涨。流经长野县内的千曲川溃堤泛滥，导致长野JR东日本的长野新干线车库淹大水。共同社目前的统计数据显示，台风已导致9人死亡，16人下落不明，大约100多人受伤。据报道，强风造成东京都涩谷区一处工地起重机吊臂扭曲，大雨引发河川溃堤有逾200名高龄者等待救援。日本内阁官房长官菅义伟称，截至日本时间13日上午7时为止，共有约37.6万个家户停电、约1.4万个家户停水。日本政府已派出约2.7万人，与各地警、消及海上自卫队人员投入救灾。（来源：中国新闻网）"
            ,"有网友爆料9月23日在厦门航空一航班上一位大妈在飞机起飞之前竟将座位旁的安全门打开而她的理由是机舱里太闷。据厦航工作人员称在该位乘客落座时乘务员已提醒她切勿触碰应急手柄但刚提醒完就在乘务员转身后这位大妈就打开了安全门"
            ,"据俄罗斯卫星网报道，当地时间25日晚，一架载有300余人的波音767-300客机，在俄罗斯巴尔瑙尔机场降落时硬着陆，右起落架冒烟。报道称，此次事件已经导致49人受伤。俄罗斯阿尔泰边疆区紧急情况部门代表透露，“截至莫斯科时间22时(北京时间26日凌晨3时)，共有49人就医。”报道称，这架客机属于俄Azur Air航空公司，从越南金兰飞往俄巴尔瑙尔。客机落地时硬着陆，右起落架冒烟，所有乘客紧急撤离。据称，事发时机上共有300余人。"
            ,"记者从四川航空获悉，9月5日零时，从南京飞往成都川航3U8994航班，因遭遇鸟击临时返航南京，目前飞机正检修。川航方面将于9月5日下午安排一趟补班航班，运输原航班乘客。9月5日凌晨，据该航班知情人士处透露，返航期间客机“盘旋了半个多小时，安全落地后航班取消，旅客送往酒店休息。”南都记者查询“飞常准”获悉，3U8994于9月4日22时11分从南京禄口机场起飞，放行时一切正常，原计划飞行3小时抵达成都。该航班执飞机型为空客319-133，机龄6.6年。航班飞行数据显示，22时18分，3U8994在飞行爬升到约3841米高度时开始下降，当时飞行速度约为727千米/时。随后在3000米左右高度，该空客客机持续飞行约半小时。机组报告22时49分正在返航，最终在5日零23分返航并在南京落地。"
            ,"根据飞常准信息，MU2809航班是从南京飞往厦门，该航班目前状态为返航，执飞机型为AIRBUSA320-251N NEO，飞机机龄仅0.4年。在南京禄口机场实际起飞时间为07:16，8:24分返航至南京。记者从东方航空获悉，今日公司南京至厦门航班，在巡航期间客舱内有旅客充电宝自燃，机组第一时间按程序妥善处置，迅速排除安全风险。为最大限度确保安全，机组决策返航南京。公司积极做好旅客服务保障工作，已尽快安排航班成行，并协助警方调查事件原因。公司提示广大旅客，严格遵循民航安全规定携带和使用类似设备。记者从东方航空了解到，当时旅客并未使用充电宝。另根据民航局航空器适航审定司2018年发布的《锂电池航空运输规范》，充电宝在飞机上应全程处于关闭状态。不应在飞机上使用充电宝为设备充电等。"
            ,"中国民用航空网讯：3日，两架在莫斯科谢列梅捷沃机场跑道上的飞机发生机翼相撞事故。其中一架属于俄罗斯航空公司(Aeroflot)的飞机，即将执行飞往北京的航班任务。所幸，没有任何人员受伤报告。报道称，事故发生在机场跑道上。一架飞机在被拖时撞上了另一架。飞机在折断机翼后受到轻微损坏。其中一架是俄罗斯航空公司(Aeroflot)的飞机，机上载有乘客，目的地是北京。相撞事故发生后，所有乘客都被紧急疏散。乘客们将不得不等待另一架飞机起飞。另一架飞机是皇家航空公司(Royal Flight)所有，该飞机当时未载有乘客。"
            ,"据@海南航空官微消息，2019年9月3日，海航HU7001航班（海口-广州）在起飞滑行过程中客舱内疑似出现烟雾，为确保安全，机组立即按程序中断起飞并滑回，组织旅客快速安全下机。该航班在更换飞机后预计将于11：30飞往广州。目前事件原因正在调查中。"
            ,"27日下午中国国航发布声明表示，8月27日，从北京飞往东京的CA183航班，在旅客登机过程中，发现飞机前货舱冒烟，机组迅速采取灭火措施并已组织全部旅客安全撤离。事件具体原因正在调查中。首都机场回应称，下午16时许，首都机场一出港航班飞机货舱冒烟，经向现场工作人员了解飞机上未见明火，首都机场已启动相关预案予以处置。目前，首都机场运行整体正常。"
            ,"中国民用航空网讯：记者从江西南昌机场了解到，2019年8月24日3:28，因3V820（南昌—列日B747-400）货运航班飞机故障占用跑道，南昌机场跑道关闭。经民航江西监管局、南昌昌北国际机场、民航江西空管分局、航空公司及各方通力合作，完成航空器搬移作业，跑道于当日14:23提前开放。事件发生后，南昌昌北国际机场及时启动应急响应，在民航江西监管局指导下，与航空公司研判并确定航空器搬移方案，期间共出动170名人员，46台应急救援车辆及航空器专用搬移设备，参与航空器搬移作业，确保了跑道尽早开放，同时避免了航空器二次损伤。当日取消航班203架次，执行航班116架次。期间，机场、航空公司做好旅客的解释和安抚工作，提前通过官微、媒体、短信等平台对外发布航班信息，帮助旅客协调航空公司办理机票退改签，并为1500余名旅客免费安排住宿，2400余名旅客提供餐食。"
            ,"中国民用航空网讯：据南昌昌北国际机场官方微博消息，经民航江西监管局、南昌昌北国际机场、民航江西空管分局、航空公司及各方通力合作，南昌机场已完成3V820航班航空器搬移作业，跑道适航并提前开放。航班将陆续恢复正常。8月24日上午，南昌机场方面曾发布消息称，因3V820(南昌—烈日 B747-400)货运航班飞机故障占用跑道，南昌机场启动应急响应，跑道关闭至14:00，当日航班将受影响。24日中午，机场方面更新消息，跑道预计关闭至17:00。截至12时，共有127架次航班取消。"
            ,"货机3V820航班，南昌—比利时列日，B747-400货运航班飞机突发紧急情况，机组将飞机紧急停在南昌机场跑道上。2019年8月24日清晨，南昌昌北国际机场一架747-400货机，滑跑起飞时因突发情况而紧急中断起飞，由于飞机全重四百多吨，巨大的刹车能量使16个轮胎中的14个放气，飞机趴在跑道上，动弹不得。机组紧急撤离时，启用了上舱的紧急充气滑梯逃生。由于南昌机场只有一条跑道，机场瞬间无法运行，进港的飞机返航，出港的飞机延误，无奈南昌机场暂时关闭，全部飞机停止起降。747趴窝跑道，南昌机场陷入关闭的窘况。"
            ,"中国民用航空网记者从上海机场集团获悉，8月23日15时39分，一架飞往上海虹桥机场的CRJ200型公务机JSU508，在虹桥机场降落后在滑行过程中偏出脱离道，机上有4名机组人员，没有旅客。机上人员已全部安全撤离，无人员受伤。目前，虹桥机场暂时关闭东跑道，使用西跑道起降，航班起降未受到影响。事故原因局方正在调查中。"
            ,"一架从中国三亚起飞的客机当地时间20日下午在哈萨克斯坦首都努尔苏丹国际机场紧急迫降。哈民航委员会消息称，该客机型号为波音B757，属于哈萨克斯坦斯卡特航空公司(SCAT)，当时其值飞的航线为中国三亚-努尔苏丹。据哈通社报道，该飞机从中国三亚起飞后，三亚机场调度中心在跑道上发现了橡胶碎片。初步判断认为，飞机在滑行中撞到了不明物体，导致左主起落架的轮胎出现破损。斯卡特航空公司随后与努尔苏丹国际机场方面取得联系，在导航中心、机场地面服务部门、警察等相关方面的配合下于20日17时左右在努尔苏丹国际机场紧急迫降。哈民航委员会表示，机上234名乘客和7名机组人员全部安全着陆。目前，事故调查委员会已就此次事故展开调查。中亚新闻网报道指出，斯卡特航空公司成立于1997年并于同年开始运营，公司总部位于哈萨克斯坦齐姆肯特市。该航空公司具有一定“价格优势”，但常因此类“有惊无险”的安全问题而见诸报端。(来源：中新网)"
            ,"据俄罗斯卫星网报道，英国航空公司(British Airways)一架客机在西班牙瓦伦西亚机场紧急着陆，机上约20名乘客受伤。英国航空公司一架客机因舱内冒烟而在西班牙瓦伦西亚机场紧急着陆。据报道，飞机是从伦敦希思罗机场起飞的。降落后，乘客使用紧急充气逃生梯撤离飞机。3名乘客因烟雾中毒被送医治疗，其他乘客则是轻微擦伤和恐慌焦虑，他们在机场接受了所提供的帮助。"
            ,"7月23日深夜，航空博主@哆啦A梦也爱国安_Barca 微博爆料称，7月22日，福州长乐国际机场，车辆差点与向前滑行的厦航客机发生碰撞。目前，福州机场方面已启动事故调查。该博主发布的监控视频画面显示，一架飞机在滑行期间，一辆SUV和一辆大巴车从远处开来，本该和大巴一起在停止线外等待的SUV，直接从左至右穿过滑行道，差点与正在滑行的飞机相撞，飞机被逼停。福州机场今天下午就此事回应称，经初步核查，7月22日，福州机场发生一起驻场单位工作人员驾驶保障车辆影响飞机滑行的情况，目前机场正在进一步调查，待核实后将对责任单位和责任人进行严肃处理。谈及机场车辆通行规则，航空专业人士@超侧卫 告诉记者，车辆避让飞机是常识。普通车辆应遵守机场内交通规则，行驶时速应低于25公里，到路口必须避让飞行器。记者查阅《民用机场运行安全管理规定》发现，该文第七十条规定，未经塔台管制员许可，任何人员、车辆不得进入运行中的跑道、滑行道；第一百二十四条规定，提供保障作业的车辆不得影响相邻机位及航空器机位滑行通道的使用。从目前的事故来看，保障车辆显然违反了上述规定。@超侧卫 告诉记者，车辆穿越滑行道逼停飞机属于很严重的事故，除保障车辆驾驶员需承担责任外，还要看该车是否有进场许可，如果没有许可，福州机场方面也要承担相应责任。"
            ,"今天下午，国航通过官方微博发文称，自称\"国航监督员\"的牛某某，实际上是国航一名因身体原因休养的员工，此次是个人因私出行，并非国航监督员。此前，国航宣传部负责人在接受媒体采访时表示，这名员工曾经是一名空姐，因患有精神疾病，很久都不工作了。国航的回应显示，他们对牛女士的病情是知晓的，这也引发了公众对于是否应该限制精神疾病患者独自乘坐飞机的疑虑。"
            ,"中国民用航空网讯：7月8日，网传南宁—上海FM9340航班飞行途中，氧气面罩突然释放，空乘小哥立即指导乘客戴上面罩。飞机备降在长沙。据@上海航空官微7月8日消息：今日南宁至虹桥航班巡航期间，机组发现增压系统故障提示，为确保安全，按程序释放旅客氧气面罩，就近备降长沙，航班正常落地，人机安全。公司积极做好旅客服务保障，航班已于15:13顺利起飞。"
            ,"中国民用航空网讯：香港国际机场昨晚发生大火！一辆停泊在中场客运廊停机坪的工程车突然起火，现场火光熊熊，期间更传出爆炸声，消防接报到场灌救，幸无人受伤。据《星岛日报》报道，事发在昨晚10时许，一辆停在中场客运廊停机坪的工程车，突然陷入火海，火势猛烈，险波及旁边一架香港航空客机，浓烟席卷半空，期间传出两下爆炸声。消防接报赶至灌救，幸当时工程车内无人，中无人受伤。消防正调查起火原因。涉事的工程车属于泛亚太平洋航空服务有限公司(PAPAS)，提供机坪工程及航线维护服务。"
            ,"中国民用航空网讯：据俄罗斯卫星通讯社27日报道，俄罗斯圣彼得堡普尔科沃机场发言人称，一架从北京飞往俄罗斯圣彼得堡的空客330飞机在发动机发出故障信号后，降落在圣彼得堡普尔科沃机场。没有人员伤亡。新闻处相关人士说：“在接近普尔科沃机场时，航班机组成员表示一个发动机出现故障，请求故障降落。事故救援队迅速赶到现场。飞机成功在机场降落并停在停机坪上。”据悉，事件没有影响其他航班，机场目前正常工作。"
            ,"中国民用航空网讯：5月26日，南航CZ3101航班因恶劣天气降落时遭遇“意外”挂出7700紧急代码（表示遇到紧急状况）。下午13时许，南航公布情况说明称，受北京雷雨天气影响，降落过程中飞机遭冰雹，挡风玻璃破裂。已安全降落，机上人员平安。随后该事件开始被广泛关注，就在今天下午5时许，北京晚报记者独家联系采访到航班机组方面给出的权威回应。被网友们“点赞”的航班机长是贺湘航，飞行经历15000小时左右，C类教员技术等级。"
            ,"中国民用航空网讯：26日上午，受北京雷雨天气影响，南航CZ3101广州-北京航班在降落过程中，飞机遭受冰雹，致使挡风玻璃破裂。据悉，该航班执飞机型为空客A380，在降落中飞机一度挂起7700代码，这是飞机在飞行中遇到特殊情况时设置的特殊代码。根据微博网友发布的图片可以看到，已经平安降落的飞机机鼻处部分蓝色油漆已经脱落，飞机挡风玻璃出现大面积裂纹。对此，南航官方回应称，机组按手册程序处置，飞机已于上午11：48分安全降落北京首都机场，机上人员平安。对此，南航官方回应称，机组按手册程序处置，飞机已于上午11：48分安全降落北京首都机场，机上人员平安。"
    };
    //以下是如何生成数据源
    //将以上信息存储到对象里，将对象存储到集合里
    //返回对象集合，也就是ListView所展示的数据源
    //ListView所展示的数据源如果比较复杂，那么它一定是一个集合，集合的泛型就是刚才定义的AirBean
    public static List<AirBean> getAllAirList(){
        List<AirBean> list=new ArrayList<>() ;
        for(int i = 0; i < title.length; i++){
            //创建并获取一个对象
            AirBean bean = new AirBean(title[i],jianjie[i],resId[i]);
            //将该对象添加到集合当中
            list.add(bean);
        }
        return list;
    }
}