package ethos.clip;

import java.io.IOException;

public final class ObjectDef {

	public static ObjectDef getObjectDef(int id) {
		if (id > streamIndices1.length) {
			id = streamIndices1.length - 1;
		}
		
		for (int j = 0; j < 20; j++) {
			if (cache[j].type == id) {
				return cache[j];
			}
		}

		cacheIndex = (cacheIndex + 1) % 20;
		ObjectDef class46 = cache[cacheIndex];

		if (id > streamIndices1.length - 1 || id < 0) {
			return null;
		}
		
		stream1.currentOffset = streamIndices1[id];

		class46.type = id;
		class46.setDefaults();
		class46.readValues(stream1);



		return class46;
	}

	private void setDefaults() {
		modelIds = null;
		modelTypes = null;
		name = null;
		description = null;
		modifiedModelColors = null;
		originalModelColors = null;
		// originalTexture = null;
		// modifiedTexture = null;
		width = 1;
		length = 1;
		solid = true;
		impenetrable = true;
		hasActions = false;
		contouredGround = false;
		delaysShading = false;
		occludes = false;
		animation = -1;
		decorDisplacement = 16;
		ambientLighting = 0;
		lightDiffusion = 0;
		actions = null;
		mapFunction = -1;
		mapscene = -1;
		inverted = false;
		castsShadow = true;
		scaleX = 128;
		scaleY = 128;
		scaleZ = 128;
		surroundings = 0;
		translateX = 0;
		translateY = 0;
		translateZ = 0;
		obstructsGround = false;
		hollow = false;
		supportItems = -1;
		varbit = -1;
		varp = -1;
		morphisms = null;
		
		this.modifiedTexture = null;
		this.originalTexture = null;
	}

	static ByteStreamExt stream1;

	private static int[] streamIndices1;
	
	public static int totalObjects;

	public static void loadConfig() throws IOException {
		stream1 = new ByteStreamExt(getBuffer("loc.dat"));
		ByteStreamExt stream = new ByteStreamExt(getBuffer("loc.idx"));
		int objects = stream.readUnsignedWord();
		System.out.println("Total objects: " + objects);
		totalObjects = objects;
		streamIndices1 = new int[objects];
		int i = 2;
		for (int j = 0; j < objects; j++) {
			streamIndices1[j] = i;
			i += stream.readUnsignedWord();
		}
		cache = new ObjectDef[20];
		for (int k = 0; k < 20; k++) {
			cache[k] = new ObjectDef();
		}
		System.out.println(objects + " Object definitions loaded.");
	}

	public static byte[] getBuffer(String s) {
		try {
			java.io.File f = new java.io.File("./Data/world/object/" + s);
			if (!f.exists())
				return null;
			byte[] buffer = new byte[(int) f.length()];
			try (java.io.DataInputStream dis = new java.io.DataInputStream(new java.io.FileInputStream(f))) {
				dis.readFully(buffer);
				dis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return buffer;
		} catch (Exception e) {
		}
		return null;
	}

	/*
	 * private void readValues(ByteStreamExt buffer) { int i = -1; label0: do {
	 * int opcode; do { opcode = buffer.readUnsignedByte(); if (opcode == 0)
	 * break label0; if (opcode == 1) { int modelLength =
	 * buffer.readUnsignedByte(); anIntArray773 = new int[modelLength];
	 * anIntArray776 = new int[modelLength]; for(int i2 = 0; i2 < modelLength;
	 * i2++) { anIntArray773[i2] = buffer.readUnsignedWord(); anIntArray776[i2]
	 * = buffer.readUnsignedByte(); } } else if (opcode == 2) name =
	 * buffer.readString(); else if (opcode == 3) description =
	 * buffer.readBytes(); else if (opcode == 5) { int length =
	 * buffer.readUnsignedByte(); anIntArray776 = null; anIntArray773 = new
	 * int[length]; for (int l1 = 0; l1 < length; l1++) anIntArray773[l1] =
	 * buffer.readUnsignedWord(); } else if (opcode == 14) anInt744 =
	 * buffer.readUnsignedByte(); else if (opcode == 15) anInt761 =
	 * buffer.readUnsignedByte(); else if (opcode == 17) aBoolean767 = false;
	 * else if (opcode == 18) aBoolean757 = false; else if (opcode == 19) { i =
	 * buffer.readUnsignedByte(); if (i == 1) hasActions = true; } else if
	 * (opcode == 21) aBoolean762 = true; else if (opcode == 22) aBoolean769 =
	 * true; else if (opcode == 23) aBoolean764 = true; else if (opcode == 24) {
	 * anInt781 = buffer.readUnsignedWord(); if (anInt781 == 65535) anInt781 =
	 * -1; } else if (opcode == 28) anInt775 = buffer.readUnsignedByte(); else
	 * if (opcode == 29) aByte737 = buffer.readSignedByte(); else if (opcode ==
	 * 39) aByte742 = buffer.readSignedByte(); else if (opcode >= 30 && opcode <
	 * 39) { if (actions == null) actions = new String[10]; actions[opcode - 30]
	 * = buffer.readString(); if (actions[opcode -
	 * 30].equalsIgnoreCase("hidden")) actions[opcode - 30] = null; } else if
	 * (opcode == 40) { int i1 = buffer.readUnsignedByte(); originalModelColors
	 * = new int[i1]; modifiedModelColors = new int[i1]; for (int i2 = 0; i2 <
	 * i1; i2++) { modifiedModelColors[i2] = buffer.readUnsignedWord();
	 * originalModelColors[i2] = buffer.readUnsignedWord(); } } else if (opcode
	 * == 60) anInt746 = buffer.readUnsignedWord(); else if (opcode == 62)
	 * aBoolean751 = true; else if (opcode == 64) aBoolean779 = false; else if
	 * (opcode == 65) anInt748 = stream.readUnsignedWord(); else if (opcode ==
	 * 66) anInt772 = stream.readUnsignedWord(); else if (opcode == 67) anInt740
	 * = stream.readUnsignedWord(); else if (opcode == 68) anInt758 =
	 * buffer.readUnsignedWord(); else if (opcode == 69) anInt768 =
	 * buffer.readUnsignedByte(); else if (opcode == 70) anInt738 =
	 * buffer.readSignedWord(); else if (opcode == 71) anInt745 =
	 * buffer.readSignedWord(); else if (opcode == 72) anInt783 =
	 * buffer.readSignedWord(); else if (opcode == 73) aBoolean736 = true; else
	 * if (opcode == 74) { aBoolean766 = true; } else { if (opcode != 75)
	 * continue; anInt760 = buffer.readUnsignedByte(); } continue label0; }
	 * while (opcode != 77); anInt774 = buffer.readUnsignedWord(); if (anInt774
	 * == 65535) anInt774 = -1; anInt749 = buffer.readUnsignedWord(); if
	 * (anInt749 == 65535) anInt749 = -1; int j1 = buffer.readUnsignedByte();
	 * childrenIDs = new int[j1 + 1]; for (int j2 = 0; j2 <= j1; j2++) {
	 * childrenIDs[j2] = buffer.readUnsignedWord(); if (childrenIDs[j2] ==
	 * 65535) childrenIDs[j2] = -1; }
	 * 
	 * } while (true); if (i == -1) { hasActions = anIntArray773 != null &&
	 * (anIntArray776 == null || anIntArray776[0] == 10); if (actions != null)
	 * hasActions = true; } if (aBoolean766) { aBoolean767 = false; aBoolean757
	 * = false; } if (anInt760 == -1) anInt760 = aBoolean767 ? 1 : 0; }
	 */

	public void readValues(ByteStreamExt stream) {
		int flag = -1;
		do {
			int type = stream.readUnsignedByte();
			if (type == 0)
				break;
			if (type == 1) {
				int len = stream.readUnsignedByte();
				if (len > 0) {
					if (modelIds == null || lowMem) {
						modelTypes = new int[len];
						modelIds = new int[len];
						for (int k1 = 0; k1 < len; k1++) {
							modelIds[k1] = stream.readUnsignedWord();
							modelTypes[k1] = stream.readUnsignedByte();
						}
					} else {
						stream.currentOffset += len * 3;
					}
				}
			} else if (type == 2)
				name = stream.readString();
			else if (type == 3)
				description = stream.readString();
			else if (type == 5) {
				int len = stream.readUnsignedByte();
				if (len > 0) {
					if (modelIds == null || lowMem) {
						modelTypes = null;
						modelIds = new int[len];
						for (int l1 = 0; l1 < len; l1++)
							modelIds[l1] = stream.readUnsignedWord();
					} else {
						stream.currentOffset += len * 2;
					}
				}
			} else if (type == 14)
				width = stream.readUnsignedByte();
			else if (type == 15)
				length = stream.readUnsignedByte();
			else if (type == 17)
				solid = false;
			else if (type == 18)
				impenetrable = false;
			else if (type == 19)
				hasActions = (stream.readUnsignedByte() == 1);
			else if (type == 21)
				contouredGround = true;
			else if (type == 22)
				delaysShading = true;
			else if (type == 23)
				occludes = true;
			else if (type == 24) { // Object Animations
				animation = stream.readUnsignedWord();
				if (animation == 65535)
					animation = -1;
			} else if (type == 28)
				decorDisplacement = stream.readUnsignedByte();
			else if (type == 29)
				ambientLighting = stream.readSignedByte();
			else if (type == 39)
				lightDiffusion = stream.readSignedByte();
			else if (type >= 30 && type < 39) {
				if (actions == null)
					actions = new String[9];
				actions[type - 30] = stream.readString();
				if (actions[type - 30].equalsIgnoreCase("hidden"))
					actions[type - 30] = null;
			} else if (type == 40) {
				int i1 = stream.readUnsignedByte();
				modifiedModelColors = new int[i1];
				originalModelColors = new int[i1];
				for (int i2 = 0; i2 < i1; i2++) {
					modifiedModelColors[i2] = stream.readUnsignedWord();
					originalModelColors[i2] = stream.readUnsignedWord();
				}
			} else if (type == 41) {
				int i1 = stream.readUnsignedByte();
				originalTexture = new short[i1];
				modifiedTexture = new short[i1];
				for (int i2 = 0; i2 < i1; i2++) {
					originalTexture[i2] = (short) stream.readUnsignedWord();
					modifiedTexture[i2] = (short) stream.readUnsignedWord();
				}
			} else if (type == 60)
				mapFunction = stream.readUnsignedWord();
			else if (type == 62)
				inverted = true;
			else if (type == 64)
				castsShadow = false;
			else if (type == 65)
				scaleX = stream.readUnsignedWord();
			else if (type == 66)
				scaleY = stream.readUnsignedWord();
			else if (type == 67)
				scaleZ = stream.readUnsignedWord();
			else if (type == 68)
				mapscene = stream.readUnsignedWord();
			else if (type == 69)
				surroundings = stream.readUnsignedByte();
			else if (type == 70)
				translateX = stream.readSignedWord();
			else if (type == 71)
				translateY = stream.readSignedWord();
			else if (type == 72)
				translateZ = stream.readSignedWord();
			else if (type == 73)
				obstructsGround = true;
			else if (type == 74)
				hollow = true;
			else if (type == 75)
				supportItems = stream.readUnsignedByte();
			else if (type == 77 || type == 92) {
				varbit = stream.readUnsignedWord();
				if (varbit == 65535)
					varbit = -1;
				
				varp = stream.readUnsignedWord();
				if (varp == 65535)
					varp = -1;
				
				int var3 = -1;
				if(type == 92) {
					var3 = stream.readUnsignedWord();
					if(var3 == 65535)
						var3 = -1;
				}
				
				
				int count = stream.readUnsignedByte();
				morphisms = new int[count + 2];
				for (int j2 = 0; j2 <= count; j2++) {
					morphisms[j2] = stream.readUnsignedWord();
					if (morphisms[j2] == 65535)
						morphisms[j2] = -1;
				}
				morphisms[count + 1] = var3;
				
			} else if(type == 78) {//TODO Figure out what these do in OSRS
				//First short = ambient sound
				stream.readUnsignedWord();
				stream.readUnsignedByte();
			} else if(type == 79) {
				stream.currentOffset += 5;
				int len = stream.readSignedByte();
				stream.currentOffset += (len * 2);
			} else if(type == 81) {
				stream.readUnsignedByte();
			} else if(type == 82) {
				stream.readUnsignedWord();
			}
		} while (true);
		if (flag == -1 && name != "null" && name != null) {
			hasActions = modelIds != null && (modelTypes == null || modelTypes[0] == 10);
			if (actions != null)
				hasActions = true;
		}
		if (hollow) {
			solid = false;
			impenetrable = false;
		}
		if (supportItems == -1)
			supportItems = solid ? 1 : 0;
	}

	private ObjectDef() {
		type = -1;
	}

	public boolean hasActions() {
		return hasActions;
	}

	public boolean hasName() {
		return name != null && name.length() > 1;
	}

	private short[] originalTexture;
	private short[] modifiedTexture;
	public boolean obstructsGround;
	private byte lightDiffusion;
	private byte ambientLighting;
	private int translateX;
	public String name;
	private int scaleZ;
	public int width;
	private int translateY;
	public int mapFunction;
	private int[] originalModelColors;
	private int scaleX;
	public int varp;
	private boolean inverted;
	public static boolean lowMem;
	private static ByteStreamExt stream;
	public int type;
	public static int[] streamIndices;
	public boolean impenetrable;
	public int mapscene;
	public int morphisms[];
	public int supportItems;
	public int length;
	public boolean contouredGround;
	public boolean occludes;
	private boolean hollow;
	public boolean solid;
	public int surroundings;
	private boolean delaysShading;
	private static int cacheIndex;
	private int scaleY;
	public int[] modelIds;
	public int varbit;
	public int decorDisplacement;
	private int[] modelTypes;
	public String description;
	public boolean hasActions;
	public boolean castsShadow;
	public int animation;
	private static ObjectDef[] cache;
	private int translateZ;
	private int[] modifiedModelColors;
	public String actions[];

	public boolean solid() {
		return solid;
	}
	
	public int width() {
		return width;
	}

	public int length() {
		return length;
	}
}

