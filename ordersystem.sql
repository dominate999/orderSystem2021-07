/*
 Navicat Premium Data Transfer

 Source Server         : ordersystem
 Source Server Type    : MySQL
 Source Server Version : 50650
 Source Host           : 150.158.191.108:3306
 Source Schema         : ordersystem

 Target Server Type    : MySQL
 Target Server Version : 50650
 File Encoding         : 65001

 Date: 04/09/2021 19:55:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dishesinfo
-- ----------------------------
DROP TABLE IF EXISTS `dishesinfo`;
CREATE TABLE `dishesinfo`  (
  `dishes_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜品编号',
  `dishes_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜品名称',
  `dishes_des` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜品描述',
  `dishes_number` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜品库存',
  `dishes_cate` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜品类别',
  `dishes_price` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜品价格',
  `dishes_sales` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜品销量',
  `dishes_photo` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜品图片',
  PRIMARY KEY (`dishes_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = ' ' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dishesinfo
-- ----------------------------
INSERT INTO `dishesinfo` VALUES (1, '懒人红烧肉', '红烧肉，一道著名的大众菜肴，各大菜系都有自己特色的红烧肉。其以五花肉为制作主料，最好选用肥瘦相间的三层肉（五花肉）来做，锅具以砂锅为主，做出来的肉肥瘦相间，香甜松软，营养丰富，入口即化。', '37', '荤菜类', '14', '23', 'lrhsr.jpg');
INSERT INTO `dishesinfo` VALUES (2, '辣椒小炒肉', '小炒肉是湖南省一道常见的特色传统名菜，属于湘菜系。麻辣鲜香，口味滑嫩。制作原料主要是五花肉和青椒、红椒等。', '16', '荤菜类', '11', '15', 'ljxcr.jpg');
INSERT INTO `dishesinfo` VALUES (3, '红烧猪蹄', '红烧猪蹄是一道传统的名菜，也是一道比较常见的家常菜，以猪蹄为主要食材，这道菜味道可口，营养价值丰富，具有美容养颜、抗衰老、促进生长、改善冠心病等功效。此菜虽营养丰富，但动脉硬化和高血压病患者应当慎食。', '41', '荤菜类', '15', '53', 'hszt.jpg');
INSERT INTO `dishesinfo` VALUES (4, '可乐鸡翅', '可乐鸡翅是一道以鸡翅和可乐为主料，以料酒、姜、酱油、盐、鸡精（可不放）作为调料制作而成的美食。', '43', '荤菜类', '10', '23', 'kljc.jpg');
INSERT INTO `dishesinfo` VALUES (5, '大补老鸭汤', '汤汁澄清香醇，滋味鲜美，鸭脂黄亮，肉酥烂鲜醇，是一种集美食养生，传统滋补，民间食疗为一体的大众消费型汤锅食品。', '23', '荤菜类', '14', '35', 'dblyt.jpg');
INSERT INTO `dishesinfo` VALUES (6, '爆炒牛蛙', '宫保牛蛙是一道以牛蛙为主要食材制作的一道荤菜。', '21', '荤菜类', '12', '15', 'bcnw.jpg');
INSERT INTO `dishesinfo` VALUES (7, '西红柿炒蛋', '西红柿炒鸡蛋是以西红柿，鸡蛋为主料制作的家常菜。味道酸甜可口，特别下饭。', '29', '蔬菜类', '9', '17', 'xhscd.jpg');
INSERT INTO `dishesinfo` VALUES (8, '辣椒炒辣椒', '辣椒洗净，单炒辣椒，特别下饭。', '17', '蔬菜类', '6', '13', 'ljclj.jpg');
INSERT INTO `dishesinfo` VALUES (9, '清炒苦瓜', '炒苦瓜以苦瓜主料制作的药膳。\r\n菜爪苦肉 香，咸鲜苦凉，苦中有鲜味，能刺激人体唾液和胃液分泌，令人食欲倍增。', '26', '蔬菜类', '5', '13', 'qckg.jpg');
INSERT INTO `dishesinfo` VALUES (10, '炒小白菜', '营养丰富，美味可口，一道简单美味的家常菜肴。', '30', '蔬菜类', '4', '16', 'cxbc.jpg');
INSERT INTO `dishesinfo` VALUES (12, '柠檬养乐多', '柠檬水含有丰富的维生素，能防止和消除皮肤色素沉着，起到美白的作用。', '35', '奶茶类', '8', '24', 'nmyld.jpg');
INSERT INTO `dishesinfo` VALUES (13, '烧仙草', '烧仙草是福建闽西南地区的传统特色饮品，其中在中国国内正宗的古早做法有用草直接烧煮的，而其他有用仙草粉，仙草液制作。', '46', '奶茶类', '11', '27', 'sxc.jpg');
INSERT INTO `dishesinfo` VALUES (14, '肉松面包', '肉松面包，即在面包上加上肉松或加入肉松做内馅制成的包点。肉松是我国著名特产之一，用猪的瘦肉或鱼肉、鸡肉除去水分后而制成，因其质地疏松而得其名。', '55', '甜点类', '16', '36', 'rsmb.jpg');
INSERT INTO `dishesinfo` VALUES (15, '苹果蛋糕', '苹果蛋糕是一种以黄油或植物黄油、白糖、鸡蛋、面粉、苹果、蛋糕发粉、桂皮粉为原料做成的颜色浅黄，质地松软的蛋糕。', '48', '甜点类', '14', '33', 'pgdg.jpg');
INSERT INTO `dishesinfo` VALUES (16, '奶油水果蛋白饼', '奶油水果蛋白饼，这是一种将蛋白、奶油和新鲜水果巧妙地融合在一起的甜点。', '57', '甜点类', '17', '23', 'nysgdbb.jpg');
INSERT INTO `dishesinfo` VALUES (17, '糖芋苗', '这是一种带甜汤的甜点，一颗q弹的芋苗放在紫色的甜汤里，光这种完美的搭配就让人不能够抵抗了，不要说品尝一口了，那种香甜软糯的气息瞬间就使我们折服了。特别是夏季冰镇后再吃，那种美味就更加的绝妙了。', '41', '甜点类', '13', '20', 'tym.jpg');
INSERT INTO `dishesinfo` VALUES (18, '绿豆糕', '绿豆糕是南方传统的甜点，把绿豆磨成粉为主料，这款甜点入口绵柔的感觉，吃上一口，嘴巴里面都是绿豆的味道，清清爽爽。', '36', '甜点类', '10', '16', 'ldg.jpg');
INSERT INTO `dishesinfo` VALUES (19, 'Biángbiáng面', 'BiángBiáng面的面条非常劲道，吃起来相当有嚼劲儿，既有肉汁的酱香还有西红柿鸡蛋的酸甜味，还有油泼辣子的香辣味！最后配一瓣蒜，美得很！老陕直呼聊咋咧！', '24', '面食类', '12', '14', 'bbm.jpg');
INSERT INTO `dishesinfo` VALUES (20, '河南烩面', '烩面，它是河南的一种传统面试。由肉片，菜，汤组成的一种美食，做出来的面香，汤美味，且经济实惠。', '36', '面食类', '14', '21', 'hnhm.jpg');
INSERT INTO `dishesinfo` VALUES (21, '山西刀削面', '刀削面是山西的一种传统面食，刀削面纯靠刀工，用刀削出来的面叶，中间厚，两边较薄。吃起来面是非常的筋道，因此出名。', '57', '面食类', '13', '45', 'sxdxm.jpg');
INSERT INTO `dishesinfo` VALUES (22, '四川担担面', '担担面源于四川，是一种由面粉，辣椒，葱花等材料做成的一种面食，喜欢吃麻辣的朋友都可以尝尝。', '49', '面食类', '15', '26', 'scddm.jpg');
INSERT INTO `dishesinfo` VALUES (23, '兰州牛肉拉面', '牛肉拉面，源于兰州地区，此面也是深受人们的喜爱，因此在别的城市，也可以吃到。', '59', '面食类', '16', '38', 'lznrlm.jpg');
INSERT INTO `dishesinfo` VALUES (24, '鲜虾云吞面', '鲜虾云吞面，愿意广州传统美食，馅料由 虾仁，鸡蛋，猪肉等制作而成，而且它的汤也是非常讲究。此菜吃了可以增强人的免疫力和性功能，补肾壮阳。', '69', '面食类', '15', '45', 'xxytm.jpg');
INSERT INTO `dishesinfo` VALUES (25, '炸酱面', '炸酱面源于北京，由肉酱，黄瓜，豆芽，黄豆等做成的一道非常美味的面食。而且被评为，中国十大面条之一。', '78', '面食类', '12', '64', 'zjm.jpg');
INSERT INTO `dishesinfo` VALUES (26, '炝锅面', '炝锅面属于豫菜面食，面多，汤浓。', '64', '面食类', '13', '35', 'qgm.jpg');
INSERT INTO `dishesinfo` VALUES (27, '陕西油泼面', '油泼面是陕西传统的特色面食之一，又叫为扯面、拽面、抻面、桢条面、香棍面等，起源于周代，并以咸阳油泼面最为著名，有鲜香味、酸辣味、香辣味。', '59', '面食类', '15', '41', 'sxypm.jpg');
INSERT INTO `dishesinfo` VALUES (28, '武汉热干面', '热干面是中国十大面条之一，是湖北武汉最出名的小吃之一，有多种做法。以油、盐、芝麻酱、色拉油、香油、细香葱、大蒜子、量卤水汁、生抽为辅助材料。', '57', '面食类', '16', '34', 'whrgm.jpg');
INSERT INTO `dishesinfo` VALUES (29, '重庆小面', '重庆小面是指麻辣素面，分汤面和干溜两种类型，麻辣味型。', '69', '面食类', '14', '54', 'cqxm.jpg');
INSERT INTO `dishesinfo` VALUES (30, '上海葱油拌面', '葱油拌面是一道以面条、猪油、黄瓜丝、葱、姜、盐、鸡精、酱油、白糖、料酒、桂皮、大料作为食材制作而成的家常面食。通常是将煮熟的面条放上葱油一起拌着吃。', '78', '面食类', '13', '46', 'shcybm.jpg');
INSERT INTO `dishesinfo` VALUES (31, '岐山臊子面', '臊子面是中国西北地区特色传统面食、著名西府小吃，以宝鸡的岐山臊子面最为正宗。在陕西关中平原及甘肃陇东等地方流行。', '67', '面食类', '15', '34', 'qsszm.jpg');
INSERT INTO `dishesinfo` VALUES (32, '延吉冷面', '是以荞面、淀粉、牛肉、辣椒面、胡萝卜等材料制作的食物，其中尤以荞麦面冷面为著称，是驰名国内外的一种深受人们喜欢的朝鲜族传统食品。', '79', '面食类', '16', '21', 'yjlm.jpg');
INSERT INTO `dishesinfo` VALUES (33, '柠檬水', '柠檬水含有丰富的维生素，能防止和消除皮肤色素沉着，起到美白的作用。', '37', '奶茶类', '5', '28', 'nms.jpg');
INSERT INTO `dishesinfo` VALUES (34, '烧仙草（大！）', '烧仙草是福建闽西南地区的传统特色饮品，其中在中国国内正宗的古早做法有用草直接烧煮的，而其他有用仙草粉，仙草液制作。', '77', '奶茶类', '15', '47', 'sxc.jpg');
INSERT INTO `dishesinfo` VALUES (35, '港式奶茶', '茶的味道略带苦涩，入口时的口感香滑同时味道醇厚，要做好一杯纯正的港式奶茶是非常繁琐的，要通过茶在两壶之间倒来倒去的这一程序，以确保奶茶内保存茶叶的醇厚。', '55', '奶茶类', '15', '44', 'gsnc.jpg');
INSERT INTO `dishesinfo` VALUES (36, '台式奶茶', '奶的味道比较浓厚，甜度也相对较甜，口感和味道更容易被大众所接纳。\r\n\r\n奶的味道比较浓厚，甜度也相对较甜，口感和味道更容易被大众所接纳。', '48', '奶茶类', '17', '23', 'tsnc.jpg');
INSERT INTO `dishesinfo` VALUES (37, '丝袜奶茶', '大家都知道丝袜奶茶其实就是类似和丝袜一样，肉肉的茶汤以及入口具有丝滑的感觉，称为丝袜奶茶的还有一个关键原因，就是在制作奶茶的工序当中会用一个酷似丝袜的网布来制作而得名，而且还是港式奶茶的延续。', '65', '奶茶类', '18', '37', 'swnc.jpg');
INSERT INTO `dishesinfo` VALUES (38, '驴打滚', '豆香馅甜，入口绵软，矿物元素丰富、提高免疫力、安神除烦。', '76', '甜点类', '14', '38', 'ldg1.jpg');
INSERT INTO `dishesinfo` VALUES (39, '紫薯山药糕', '紫薯和山药的营养都非常丰富，这款点心将这两种食物结合在一起，看着图片上的也是很有食欲呢，而且热量不是很高，所以不用太担心长胖的问题，而且还很好消化。', '64', '甜点类', '16', '34', 'zssyg.jpg');
INSERT INTO `dishesinfo` VALUES (40, '荷花酥', '用油酥面做成的，因为外形像荷花而得名，看起来非常的好看也非常可爱，而且还非常的文艺，吃起来也是很好吃的，又香又甜而且很酥脆，口感特别好。', '56', '甜点类', '14', '36', 'hhs.jpg');
INSERT INTO `dishesinfo` VALUES (41, '桂花糕', '桂花是一种常用的中草药，具有生津健脾，去火消炎和活血益气的功效。', '100', '甜点类', '13', '46', 'ghg.jpg');
INSERT INTO `dishesinfo` VALUES (42, '蜜汁玫瑰芋头', '芋头吃起来非常绵软，而且十分爽口，上面放上玫瑰酱和蜂蜜，入口顺滑甜蜜，而且还有浓浓的玫瑰花的香气，既好吃又好看，玫瑰花还能美容养颜。', '160', '甜点类', '16', '87', 'mzmgyt.jpg');
INSERT INTO `dishesinfo` VALUES (43, '沙河蛋糕', '一种甜美无比的巧克力馅，以这种巧克力涂抹的内裹杏仁及果酱的巧克力奶油蛋糕。', '123', '甜点类', '17', '95', 'shdg.jpg');
INSERT INTO `dishesinfo` VALUES (44, '维也纳巧克力蛋糕', '维也纳巧克力杏仁蛋糕有着使用可口的牛奶巧克力和甜美杏仁制成的外层，以及铺满碎杏仁和可可亚的内层，因此整个蛋糕吃起 来口感既甜美又细腻。', '64', '甜点类', '20', '34', 'wynqklxldg.jpg');
INSERT INTO `dishesinfo` VALUES (45, '槭风蛋糕', '海绵蛋糕的口感比槭风蛋糕更结实、更绵密，口感和组织特别柔 软绵滑。', '87', '甜点类', '25', '58', 'qfdg.jpg');
INSERT INTO `dishesinfo` VALUES (46, '马卡龙', '是一种用蛋白、杏仁粉、白砂糖和糖霜制作，并夹有水果酱或奶油的法式甜点。口感丰富，外脆内柔，外观五彩缤纷，精致小巧。', '188', '甜点类', '24', '102', 'mkl.jpg');
INSERT INTO `dishesinfo` VALUES (47, '家常红烧肉', '红烧肉，一道著名的大众菜肴，各大菜系都有自己特色的红烧肉。其以五花肉为制作主料，最好选用肥瘦相间的三层肉（五花肉）来做，锅具以砂锅为主，做出来的肉肥瘦相间，香甜松软，营养丰富，入口即化。', '160', '荤菜类', '17', '123', 'jchsr.jpg');
INSERT INTO `dishesinfo` VALUES (48, '农家大炒肉', '小炒肉是湖南省一道常见的特色传统名菜，属于湘菜系。麻辣鲜香，口味滑嫩。制作原料主要是五花肉和青椒、红椒等。', '123', '荤菜类', '14', '92', 'njxcr.jpg');
INSERT INTO `dishesinfo` VALUES (49, '糖醋排骨', '酸甜适中，不油不腻，口感丰富细腻，不会觉得任何一种调料的突兀。\r\n\r\n颜色呈糖稀色，不浓不淡。就是拿汁水拌米饭也是一样好吃', '110', '荤菜类', '13', '86', 'tcpg.jpg');
INSERT INTO `dishesinfo` VALUES (50, '大盘鸡', '菜品色彩鲜艳、爽滑麻辣的鸡肉配上软糯甜嫩的土豆，辣中有香、粗中有细，堪称餐桌上的佳品。', '91', '荤菜类', '16', '59', 'dpj.jpg');
INSERT INTO `dishesinfo` VALUES (51, '红烧猪尾', '猪尾巴比起猪脚要容易熟，而且口感也没那么油腻，同样是胶原蛋白营养两不误。', '86', '荤菜类', '18', '77', 'hszw.jpg');
INSERT INTO `dishesinfo` VALUES (52, '土豆窝窝', '土豆窝窝，一蒸一煮一凉拌，做法简单，酸辣爽口、光滑劲道Q弹、炎热的夏天来一碗真解馋。', '59', '蔬菜类', '7', '38', 'tdww.jpg');
INSERT INTO `dishesinfo` VALUES (53, '香醋花生米拌黄瓜', '夏日开胃菜～香醋花生米拌黄瓜，酸甜口味，黄瓜脆爽，花生米香脆，妥妥的开胃小菜！', '64', '蔬菜类', '4', '46', 'tchsmbhg.jpg');
INSERT INTO `dishesinfo` VALUES (54, '蒸茄子', '鸡蛋和茄子这样蒸，简单美味、低卡又营养、保证拿起筷子停不下来', '78', '蔬菜类', '10', '55', 'zqz.jpg');
INSERT INTO `dishesinfo` VALUES (55, '蒜香海带丝', '海带丝入口丝滑，有嚼劲，加上蒜香的味道，简直极佳美味。', '61', '蔬菜类', '8', '33', 'sxhds.jpg');
INSERT INTO `dishesinfo` VALUES (56, '酸辣柠檬鱼片', '适合夏天可以拌着吃的酸辣柠檬鱼片，口感酸爽鲜嫩。这个做法也适合酸辣柠檬虾一样好吃。', '86', '荤菜类', '14', '59', 'slnmyp.jpg');
INSERT INTO `dishesinfo` VALUES (57, '酸梅酱鸭', '鸭肉的嫩度，再加上酸梅酱的调合，让肉吃的不再腻，越吃越有味。', '98', '荤菜类', '15', '65', 'smjy.jpg');
INSERT INTO `dishesinfo` VALUES (58, '金针菇拌火腿肠', '火腿肠的劲道加上金针菇的滑口，是极佳的小吃。', '75', '荤菜类', '8', '56', 'jzgbht.jpg');
INSERT INTO `dishesinfo` VALUES (59, '捞拌小鲍鱼', '捞拌汁是这道菜的灵魂，它的特点是酸甜鲜咸，微辣，炎热的夏季吃起来冰冰凉，透心的爽，好吃到停不下来！', '109', '荤菜类', '19', '66', 'lbxby.jpg');
INSERT INTO `dishesinfo` VALUES (60, '柠檬鸡爪', '鸡爪的劲道，入口有嚼劲，再加上柠檬的酸味，让人回味无穷。', '95', '荤菜类', '13', '64', 'nmjz.jpg');
INSERT INTO `dishesinfo` VALUES (61, '凉拌空心菜', '空心菜的嫩度使人越吃越有味。', '90', '蔬菜类', '7', '54', 'lbkxc.jpg');
INSERT INTO `dishesinfo` VALUES (62, '凉拌豆皮', '一盘凉拌豆腐皮，清香爽口，美味不可敌', '102', '蔬菜类', '5', '89', 'lbdp.jpg');
INSERT INTO `dishesinfo` VALUES (63, '香汁小皮蛋', '小皮蛋的蛋白质美味无敌，香飘飘。', '56', '蔬菜类', '6', '10', 'xzxpd.jpg');
INSERT INTO `dishesinfo` VALUES (64, '北海道黑皮大西瓜', '黑皮大西瓜的贵也是不无道理的，据说这种西瓜的的生长条件十分严苛，据说只有在日本的北海道才能生长，而且每年只能产大约100颗。物以稀为贵嘛，所以自然不无道理。再加上西瓜在日本，本来就是奢侈品水果。', '94', '水果类', '6666', '15', 'bhdhpdxg.jpg');
INSERT INTO `dishesinfo` VALUES (65, '澳洲蜜橘', '果肉十分紧致,每一颗果粒都很鲜嫩,每一次咀嚼都很享受', '74', '水果类', '8888', '9', 'azmj.jpg');
INSERT INTO `dishesinfo` VALUES (66, '广西仙人蕉', '仙人蕉食用方便，剥皮即食，味道香甜、口感软绵，是一种老少皆宜的水果', '55', '水果类', '40', '25', 'gxxrj.jpg');
INSERT INTO `dishesinfo` VALUES (67, '红富士苹果', '其果肉紧密，比其他很多苹果变种都要甜美和清脆，因此受到全世界消费者的广泛喜爱。', '98', '水果类', '26', '58', 'hfspg.jpg');
INSERT INTO `dishesinfo` VALUES (68, '贵妃玫瑰葡萄', '果粒着生紧密，果皮薄，果肉脆，味甜，有浓玫瑰香味', '40', '水果类', '50', '66', 'gfmgpt.jpg');
INSERT INTO `dishesinfo` VALUES (69, '青皮芒', '青皮芒营养丰富，食用芒果具抗癌、美化肌肤、防治高血压、动脉硬化、防治便秘、清肠胃的功效', '49', '水果类', '30', '25', 'qpm.jpg');
INSERT INTO `dishesinfo` VALUES (70, '酱香鸡肉炒米粉', '令人上头的快餐美食,边关月新疆炒米粉', '19', '面食类', '20', '13', 'jxjrcmf.jpg');
INSERT INTO `dishesinfo` VALUES (71, '北京烤鸭', '用料为优质肉食鸭北京鸭，果木炭火烤制，色泽红润，肉质肥而不腻，外脆里嫩', '64', '荤菜类', '69', '150', 'bjky.jpg');
INSERT INTO `dishesinfo` VALUES (72, '酸奶菠萝蜜', '放在柜子里金灿灿的一个个,看着就让人狂咽口水!', '21', '甜点类', '13', '31', 'snblm.jpeg');
INSERT INTO `dishesinfo` VALUES (73, '三门峡胡辣汤', '是中国早餐中常见的传统汤类名吃，用胡椒，辣椒，牛肉粒，骨汤，粉芡，细粉条，黄花菜，花生，木耳等制作而成', '56', '蔬菜类', '6', '222', 'hlt.jpg');
INSERT INTO `dishesinfo` VALUES (74, '狗不理包子', '是中国天津的一道闻名中外的传统小吃，该小吃以一道由面粉、猪肉等材料制作而成的小吃', '21', '甜点类', '18', '111', 'gblbz.jpg');
INSERT INTO `dishesinfo` VALUES (75, '西安肉夹馍', '肉夹馍合腊汁肉、白吉馍为一体，互为烘托，将各自滋味发挥到极致。馍香肉酥，肥而不腻，回味无穷。', '43', '荤菜类', '26', '78', 'rjm.jpg');
INSERT INTO `dishesinfo` VALUES (76, '肥西老母鸡汤', '选优良鸡，用古井水，自配秘方，精火熬炖烹饪的老母鸡汤溢鲜飘香，诱人垂涎。路人闻香下马，食客击案称鲜。有名士赠匾，颂曰“华夏一绝”', '30', '荤菜类', '167', '79', 'fxlmj.jpg');
INSERT INTO `dishesinfo` VALUES (77, '羊肉泡馍', '它烹制精细，料重味醇，肉烂汤浓，肥而不腻，营养丰富，香气四溢，诱人食欲，食后回味无穷。', '25', '荤菜类', '39', '119', 'yrpm.jpg');
INSERT INTO `dishesinfo` VALUES (78, '榴莲披萨', '榴莲披萨是由浓郁的进口芝士搭配上姜黄色的榴莲果肉，味浓，奶油味四溢，果肉拥有凝脂似的质感，层次丰富，入口嫩滑细致，外形、色泽、肉质近乎完美。', '64', '甜点类', '64', '88', 'llps.jpg');
INSERT INTO `dishesinfo` VALUES (79, '意大利面', '作为意大利面的法定原料，杜兰小麦是最硬质的小麦品种，具有高密度、高蛋白质、高筋度等特点，其制成的意大利面通体呈黄色，耐煮、口感好。', '61', '面食类', '18', '20', 'ydlm.jpg');
INSERT INTO `dishesinfo` VALUES (80, '珍珠翡翠白玉汤', '珍珠翡翠白玉汤是一道用白菜帮子、菠菜叶儿(翡翠)，馊豆腐(白玉)和剩锅巴碎米粒儿(珍珠)做成的一道汤品。', '9', '蔬菜类', '7', '122', 'zzfcbyt.jpg');
INSERT INTO `dishesinfo` VALUES (81, '三刀土豆花', '这道土豆花是家喻户晓的小吃，在重庆各大城区里无数个小摊卖这个且人人都爱吃！每每上街都会买一份吃的酣畅淋漓', '23', '蔬菜类', '14', '54', 'sdtdh.jpg');
INSERT INTO `dishesinfo` VALUES (82, '番石榴', '番石榴味道甘甜多汁，果肉柔滑，果心较少无籽，常吃可以补充人体所缺乏的营养成分，可以强身健体提高身体素质。比起苹果，番石榴所含有的脂肪少38%，卡路里少42%。', '33', '水果类', '12', '33', 'fsl.jpg');
INSERT INTO `dishesinfo` VALUES (83, '释迦果', '果实为聚生果，由数十个小瓣组成，每个瓣里含有一颗乌黑晶亮的小核（黑色的籽）。呈卵形，未熟果绿色，成熟果呈淡绿黄色。味略甜，奶黄油色或乳白色，呈乳蛋糕状，并具芳香，鲜食香甜，风味甚佳。', '44', '水果类', '34', '39', 'sjg.jpg');
INSERT INTO `dishesinfo` VALUES (84, '蛇皮果', '蛇皮果的果肉有益于人体的皮肤，可以作为美容水果食用；蛇皮果钾含量很高，果胶含量丰富，特别适合长期用脑人群食用，对人脑有益，也被称为“记忆之果”。', '24', '水果类', '59', '29', 'spg.jpg');
INSERT INTO `dishesinfo` VALUES (85, '蛋黄果', '海南蛋黄果美容功效：蛋黄果含有丰富的磷、铁、钙、维生素C、类胡萝卜素等营养物质及人体必须的十七种氨基酸，具有帮助消化、化痰、补肾、提神醒脑、活血强身、镇静止痛、减压降脂等功效。', '23', '水果类', '28', '23', 'dhg.jpg');
INSERT INTO `dishesinfo` VALUES (86, '蟠桃', '夫妻本是前生定，曾向蟠桃会里来。', '67', '水果类', '15', '34', 'pt.jpg');
INSERT INTO `dishesinfo` VALUES (87, '蓝莓', '蓝莓果实中含有丰富的营养成分，尤其富含花青素，它不仅具有良好的营养保健作用，还具有防止脑神经老化、强心、抗癌、软化血管、增强人体免疫等功能。', '13', '水果类', '12', '64', 'lm.jpg');
INSERT INTO `dishesinfo` VALUES (88, '猕猴桃', '\r\n猕猴桃除含有猕猴桃碱、蛋白水解酶、单宁果胶和糖类等有机物，以及钙、钾、硒、锌、锗等微量元素和人体所需17种氨基酸外，还含有丰富的维生素C、葡萄酸、果糖、柠檬酸、苹果酸、脂肪。', '43', '水果类', '19', '34', 'mht.jpg');
INSERT INTO `dishesinfo` VALUES (89, '杨梅', '杨梅枝繁叶茂，树冠圆整，初夏又有红果累累，十分可爱，是园林绿化结合生产的优良树种。经济用途果味酸甜适中，既可直接食用，又可加工成杨梅干、酱、蜜饯等，还可酿酒，有止渴、生津、助消化等功能。', '67', '水果类', '21', '69', 'ym.webp');
INSERT INTO `dishesinfo` VALUES (90, '玉露香梨', '玉露香梨继承了库尔勒香梨所特有的肉质细嫩、口味香甜、无渣，果面着红色等优良品质，克服了香梨果小、心大、可食率低，果形不正的缺点，是一个优质、耐藏、中熟的库尔勒香梨型大果新品种。', '61', '水果类', '55', '29', 'ylxl.jpg');
INSERT INTO `dishesinfo` VALUES (92, '椰子', '椰水具有滋补、清暑解渴的功效，主治暑热类渴，津液不足之口渴；椰子壳油治癣，疗杨梅疮。', '21', '水果类', '35', '76', 'yz.jpg');
INSERT INTO `dishesinfo` VALUES (93, '荔枝', '荔枝味甘、酸、性温，入心、脾、肝经；可止呃逆，止腹泻，是顽固性呃逆及五更泻者的食疗佳品，同时有补脑健身，开胃益脾，有促进食欲之功效。', '31', '水果类', '29', '36', 'lz.jpg');

-- ----------------------------
-- Table structure for evainfo
-- ----------------------------
DROP TABLE IF EXISTS `evainfo`;
CREATE TABLE `evainfo`  (
  `eva_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价编号',
  `eva_content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户编号',
  `eva_time` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价时间',
  `eva_degree` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '好评度',
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  PRIMARY KEY (`eva_id`) USING BTREE,
  INDEX `USER_ID`(`user_id`) USING BTREE,
  CONSTRAINT `evainfo_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `userinfo` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = ' ' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of evainfo
-- ----------------------------
INSERT INTO `evainfo` VALUES (1, '很好吃，我觉得很好！\r\n', 1, '2021-07-10-14.32', '5', 27);
INSERT INTO `evainfo` VALUES (2, '我认为这个味道不是很好', 2, '2021-07-06-14:25', '1', 2);
INSERT INTO `evainfo` VALUES (3, '一般般吧，希望店家再接再厉', 2, '2021-07-02-05:06', '3', 3);
INSERT INTO `evainfo` VALUES (5, '无法接受的味道', 3, '2021-05-23-10:32', '1', 5);
INSERT INTO `evainfo` VALUES (6, '有点好吃~', 3, '2020-05-12-10:35', '4', 6);
INSERT INTO `evainfo` VALUES (7, '这个我认为非常不错咧，虽然但是，你们大家都懂得的，我就不用多说了。', 4, '2013-06-23-16:35', '5', 7);
INSERT INTO `evainfo` VALUES (8, '好吃爆掉', 5, '2020-03-12-10:42', '5', 8);
INSERT INTO `evainfo` VALUES (9, 'justsoso', 5, '2024-06-06-13:21', '3', 9);
INSERT INTO `evainfo` VALUES (10, '贵死了，cao', 4, '2019-01-01-13:02', '5', 10);
INSERT INTO `evainfo` VALUES (11, '好吃！', 1, '2019-01-10-14.32', '5', 5);
INSERT INTO `evainfo` VALUES (30, 'HAO', 4, '2021-07-23 09:35', '4', 87);
INSERT INTO `evainfo` VALUES (31, '好\r\n', 4, '2021-07-23 12:01', '4', 88);

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `order_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单名称',
  `order_time` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单结算时间',
  `order_status` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态(未接单，已配送，未配送，已完成）',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `order_number` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单内食物总数量',
  `order_money` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单总金额',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `USER_ID`(`user_id`) USING BTREE,
  CONSTRAINT `orderinfo_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `userinfo` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 93 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = ' ' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES (1, 'J1763848', '2020-01-18-15:49', '已配送', 4, '4', '46');
INSERT INTO `orderinfo` VALUES (2, 'A0254545', '2020-02-15-13:36', '已完成', 1, '1', '13');
INSERT INTO `orderinfo` VALUES (3, 'B1287832', '2020-09-23-17:35', '已完成', 3, '2', '29');
INSERT INTO `orderinfo` VALUES (4, 'A1212313', '2021-01-23-11:23', '已完成', 3, '11', '290');
INSERT INTO `orderinfo` VALUES (5, 'B8848431', '2021-02-16-16:29', '已完成', 1, '2', '25');
INSERT INTO `orderinfo` VALUES (6, 'D1591509', '2021-03-02-19:48', '已完成', 2, '2', '30');
INSERT INTO `orderinfo` VALUES (7, 'D8984748', '2021-04-11-19:32', '已完成', 5, '3', '37');
INSERT INTO `orderinfo` VALUES (8, 'A1354812', '2021-04-17-15:13', '已完成', 5, '2', '18');
INSERT INTO `orderinfo` VALUES (9, 'C8498100', '2021-05-05-18:48', '已完成', 3, '2', '26');
INSERT INTO `orderinfo` VALUES (10, 'T1991544', '2021-05-28-13:49', '已完成', 4, '1', '6666');
INSERT INTO `orderinfo` VALUES (27, 'E9299424', '2021-06-18-10:43', '已完成', 4, '3', '36');
INSERT INTO `orderinfo` VALUES (28, 'J1763845', '2021-07-18-15:49', '已取消', 4, '3', '36');
INSERT INTO `orderinfo` VALUES (35, 'X2886728', '2021-07-20 14:38', '已完成', 1, '1', '8888');
INSERT INTO `orderinfo` VALUES (36, 'Y2200515', '2021-07-20 14:40', '已完成', 1, '2', '33');
INSERT INTO `orderinfo` VALUES (75, 'H5429575', '2021-07-22 15:53', '已配送', 2, '2', '108');
INSERT INTO `orderinfo` VALUES (76, 'F6974630', '2021-07-22 16:09', '已完成', 2, '1', '69');
INSERT INTO `orderinfo` VALUES (77, 'E7465672', '2021-07-22 16:12', '已完成', 2, '1', '39');
INSERT INTO `orderinfo` VALUES (79, 'Y9428285', '2021-07-22 17:09', '已接单', 2, '4', '54');
INSERT INTO `orderinfo` VALUES (80, 'V9677662', '2021-07-22 17:11', '未接单', 2, '6', '384');
INSERT INTO `orderinfo` VALUES (81, 'R3544668', '2021-07-22 17:16', '未接单', 2, '6', '42218');
INSERT INTO `orderinfo` VALUES (82, 'P8654940', '2021-07-22 17:18', '已配送', 2, '2', '13332');
INSERT INTO `orderinfo` VALUES (83, 'D8686595', '2021-07-22 17:20', '已接单', 2, '7', '483');
INSERT INTO `orderinfo` VALUES (84, 'V2622043', '2021-07-22 19:17', '已接单', 15, '4', '26664');
INSERT INTO `orderinfo` VALUES (85, 'X4473204', '2021-07-22 19:28', '已配送', 15, '8', '31173');
INSERT INTO `orderinfo` VALUES (86, 'N2266206', '2021-07-22 19:35', '已完成', 3, '3', '114');
INSERT INTO `orderinfo` VALUES (87, 'T6643863', '2021-07-23 09:33', '已完成', 4, '2', '206');
INSERT INTO `orderinfo` VALUES (88, 'L3576716', '2021-07-23 12:00', '已完成', 4, '7', '444');
INSERT INTO `orderinfo` VALUES (90, 'U3930460', '2021-07-24 15:10', '未接单', 3, '1', '15');
INSERT INTO `orderinfo` VALUES (91, 'H1210072', '2021-08-05 12:38', '未接单', 3, '1', '18');
INSERT INTO `orderinfo` VALUES (92, 'Y3128745', '2021-08-05 12:39', '未接单', 3, '1', '19');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `orderitem_id` int(128) NOT NULL AUTO_INCREMENT COMMENT '单种菜品对应的编号',
  `order_id` int(11) NOT NULL COMMENT '单种菜品对应的所在订单号',
  `dishes_id` int(11) NOT NULL COMMENT '单种菜品对应的菜品编号',
  `orderitem_number` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单种菜品所对应的数量',
  `orderitem_money` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单种菜品所对应的金额',
  PRIMARY KEY (`orderitem_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 113 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES (1, 1, 2, '3', '33');
INSERT INTO `orderitem` VALUES (2, 1, 1, '1', '13');
INSERT INTO `orderitem` VALUES (3, 2, 21, '1', '13');
INSERT INTO `orderitem` VALUES (4, 3, 41, '1', '13');
INSERT INTO `orderitem` VALUES (5, 3, 42, '1', '16');
INSERT INTO `orderitem` VALUES (6, 4, 67, '10', '260');
INSERT INTO `orderitem` VALUES (7, 4, 69, '1', '30');
INSERT INTO `orderitem` VALUES (8, 5, 51, '1', '18');
INSERT INTO `orderitem` VALUES (9, 5, 52, '1', '7');
INSERT INTO `orderitem` VALUES (10, 6, 34, '2', '30');
INSERT INTO `orderitem` VALUES (11, 7, 56, '1', '14');
INSERT INTO `orderitem` VALUES (12, 7, 57, '1', '15');
INSERT INTO `orderitem` VALUES (13, 7, 58, '1', '8');
INSERT INTO `orderitem` VALUES (14, 8, 11, '2', '18');
INSERT INTO `orderitem` VALUES (15, 9, 19, '1', '12');
INSERT INTO `orderitem` VALUES (16, 9, 20, '1', '14');
INSERT INTO `orderitem` VALUES (17, 10, 64, '1', '6666');
INSERT INTO `orderitem` VALUES (30, 27, 3, '2', '30');
INSERT INTO `orderitem` VALUES (31, 27, 8, '1', '6');
INSERT INTO `orderitem` VALUES (32, 28, 3, '2', '30');
INSERT INTO `orderitem` VALUES (33, 28, 8, '1', '6');
INSERT INTO `orderitem` VALUES (34, 35, 65, '1', '8888');
INSERT INTO `orderitem` VALUES (35, 36, 35, '1', '15');
INSERT INTO `orderitem` VALUES (36, 36, 37, '1', '18');
INSERT INTO `orderitem` VALUES (81, 75, 71, '1', '69');
INSERT INTO `orderitem` VALUES (82, 75, 77, '1', '39');
INSERT INTO `orderitem` VALUES (83, 76, 71, '1', '69');
INSERT INTO `orderitem` VALUES (84, 77, 77, '1', '39');
INSERT INTO `orderitem` VALUES (85, 79, 33, '3', '15');
INSERT INTO `orderitem` VALUES (86, 79, 77, '1', '39');
INSERT INTO `orderitem` VALUES (87, 80, 71, '5', '345');
INSERT INTO `orderitem` VALUES (88, 80, 77, '1', '39');
INSERT INTO `orderitem` VALUES (89, 81, 64, '5', '33330');
INSERT INTO `orderitem` VALUES (90, 81, 65, '1', '8888');
INSERT INTO `orderitem` VALUES (91, 82, 64, '2', '13332');
INSERT INTO `orderitem` VALUES (92, 83, 71, '7', '483');
INSERT INTO `orderitem` VALUES (93, 84, 64, '4', '26664');
INSERT INTO `orderitem` VALUES (94, 85, 64, '2', '13332');
INSERT INTO `orderitem` VALUES (95, 85, 65, '2', '17776');
INSERT INTO `orderitem` VALUES (96, 85, 34, '2', '30');
INSERT INTO `orderitem` VALUES (97, 85, 36, '1', '17');
INSERT INTO `orderitem` VALUES (98, 85, 37, '1', '18');
INSERT INTO `orderitem` VALUES (99, 86, 45, '2', '50');
INSERT INTO `orderitem` VALUES (100, 86, 78, '1', '64');
INSERT INTO `orderitem` VALUES (101, 87, 76, '1', '167');
INSERT INTO `orderitem` VALUES (102, 87, 77, '1', '39');
INSERT INTO `orderitem` VALUES (103, 88, 71, '3', '207');
INSERT INTO `orderitem` VALUES (104, 88, 43, '1', '17');
INSERT INTO `orderitem` VALUES (105, 88, 76, '1', '167');
INSERT INTO `orderitem` VALUES (106, 88, 77, '1', '39');
INSERT INTO `orderitem` VALUES (107, 88, 15, '1', '14');
INSERT INTO `orderitem` VALUES (110, 90, 57, '1', '15');
INSERT INTO `orderitem` VALUES (111, 91, 37, '1', '18');
INSERT INTO `orderitem` VALUES (112, 92, 59, '1', '19');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_account` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `user_password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `user_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `user_addressed` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户地址',
  `user_phone` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号码',
  `user_photo` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户头像',
  `user_integral` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户积分',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = ' ' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, 'Atrium', '123456', '陈非凡', '襄樊县襄樊乡襄樊村襄樊小区', '12345678911', 'photo2.jpg', '89815');
INSERT INTO `userinfo` VALUES (2, 'rt777', '123456', '沃嫩爹', '匈牙利阿卡其乌尔利斯大利街280372号', '12345678910', 'photo2.jpg', '2483');
INSERT INTO `userinfo` VALUES (3, 'Klering', '123456', '傅图图', '翻斗大街翻斗花园二号楼1001室', '12345678910', 'photo2.jpg', '4351');
INSERT INTO `userinfo` VALUES (4, '邪王真眼！', '124578963', '程阿尔卡夫斯基月健', '阿联酋南半岛可夫达吉汉区', '12345678912', 'user_4.png', '206852');
INSERT INTO `userinfo` VALUES (5, 'AISHKD', '123456', '颜凡凡', '加拿大渥太华市', '12345678910', 'photo1.jpg', '404');
INSERT INTO `userinfo` VALUES (14, '555151515', '123456', '555151515', '翻斗花园', '19299999999', 'photo1.jpg', '0');
INSERT INTO `userinfo` VALUES (15, 'admin', 'admin', 'admin', '地址！', '19299999999', 'user_15.png', '999999');
INSERT INTO `userinfo` VALUES (16, '邹好闲', '123456', 'haoxian', 'xxxx', '19299999999', 'photo2.jpg', '0');
INSERT INTO `userinfo` VALUES (17, '乌西迪西', '123456', '乌西迪西', '花园世界', '19299999999', 'photo2.jpg', '0');

-- ----------------------------
-- View structure for v_evainfo-userinfo
-- ----------------------------
DROP VIEW IF EXISTS `v_evainfo-userinfo`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_evainfo-userinfo` AS select `evainfo`.`eva_id` AS `eva_id`,`evainfo`.`eva_content` AS `eva_content`,`evainfo`.`user_id` AS `user_id`,`evainfo`.`eva_time` AS `eva_time`,`evainfo`.`eva_degree` AS `eva_degree`,`userinfo`.`user_account` AS `user_account`,`userinfo`.`user_name` AS `user_name`,`userinfo`.`user_addressed` AS `user_addressed`,`userinfo`.`user_phone` AS `user_phone`,`userinfo`.`user_photo` AS `user_photo` from (`evainfo` join `userinfo` on((`evainfo`.`user_id` = `userinfo`.`user_id`))) order by `evainfo`.`eva_id`;

-- ----------------------------
-- View structure for v_orderinfo-userinfo
-- ----------------------------
DROP VIEW IF EXISTS `v_orderinfo-userinfo`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_orderinfo-userinfo` AS select `orderinfo`.`order_id` AS `order_id`,`orderinfo`.`order_name` AS `order_name`,`orderinfo`.`order_time` AS `order_time`,`orderinfo`.`order_status` AS `order_status`,`orderinfo`.`user_id` AS `user_id`,`orderinfo`.`order_number` AS `order_number`,`orderinfo`.`order_money` AS `order_money`,`userinfo`.`user_name` AS `user_name`,`userinfo`.`user_addressed` AS `user_addressed`,`userinfo`.`user_phone` AS `user_phone`,`userinfo`.`user_integral` AS `user_integral` from (`userinfo` join `orderinfo` on((`userinfo`.`user_id` = `orderinfo`.`user_id`))) order by `orderinfo`.`order_id`;

-- ----------------------------
-- View structure for v_orderitem-dishesinfo
-- ----------------------------
DROP VIEW IF EXISTS `v_orderitem-dishesinfo`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_orderitem-dishesinfo` AS select `orderitem`.`orderitem_id` AS `orderitem_id`,`orderitem`.`order_id` AS `order_id`,`orderitem`.`dishes_id` AS `dishes_id`,`orderitem`.`orderitem_number` AS `orderitem_number`,`orderitem`.`orderitem_money` AS `orderitem_money`,`dishesinfo`.`dishes_name` AS `dishes_name`,`dishesinfo`.`dishes_des` AS `dishes_des`,`dishesinfo`.`dishes_cate` AS `dishes_cate`,`dishesinfo`.`dishes_price` AS `dishes_price`,`dishesinfo`.`dishes_photo` AS `dishes_photo` from (`dishesinfo` join `orderitem` on((`dishesinfo`.`dishes_id` = `orderitem`.`dishes_id`))) order by `orderitem`.`orderitem_id`;

SET FOREIGN_KEY_CHECKS = 1;
