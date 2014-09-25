package com.shunix.antiemulatordetection;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * @author Shunix
 */
public class EmulatorHook implements IXposedHookLoadPackage, IXposedHookZygoteInit {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        // Hook getDeviceId()
        XposedHelpers.findAndHookMethod("android.telephony.TelephonyManager", loadPackageParam.classLoader, "getDeviceId", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                // Return a valid Galaxy S4 IMEI
                XposedBridge.log("Hook getDeviceId method");
                return "357196053112533";
            }
        });
    }

    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
        // Hook SystemProperties
        XposedBridge.hookAllMethods(Class.forName("android.os.SystemProperties"), "get", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                String param = ((String[]) methodHookParam.args)[0];
                if(param.equals("ro.build.id")) {
                    return "JZO54K";
                } else if(param.equals("ro.build.display.id")) {
                    return "JZO54K.I739KEAMF1";
                } else if(param.equals("ro.build.version.incremental")) {
                    return "I739KEAMF1";
                } else if(param.equals("ro.build.version.sdk")) {
                    return 16;
                } else if(param.equals("ro.build.version.codename")) {
                    return "REL";
                } else if(param.equals("ro.build.version.release")) {
                    return "4.1.2";
                } else if(param.equals("ro.build.date")) {
                    return "Wed Jun 26 12:36:29 KST 2013";
                } else if(param.equals("ro.build.date.utc")) {
                    return 1372217789000l;
                } else if(param.equals("ro.build.type")) {
                    return "user";
                } else if(param.equals("ro.build.user")) {
                    return "se.infra";
                } else if(param.equals("ro.build.host")) {
                    return "S0210-08";
                } else if(param.equals("ro.build.tags")) {
                    return "release-keys";
                } else if(param.equals("ro.product.model")) {
                    return "SCH-I739";
                } else if(param.equals("ro.product.brand")) {
                    return "samsung";
                } else if(param.equals("ro.product.name")) {
                    return "kyleplusctc";
                } else if(param.equals("ro.product.device")) {
                    return "kyleplusctc";
                } else if(param.equals("ro.product.board")) {
                    return "MSM8625";
                } else if(param.equals("ro.product.cpu.abi")) {
                    return "armeabi-v7a";
                } else if(param.equals("ro.product.cpu.abi2")) {
                    return "armeabi";
                } else if(param.equals("ro.product_ship")) {
                    return "true";
                } else if(param.equals("ro.product.manufacturer")) {
                    return "samsung";
                } else if(param.equals("ro.product.locale.language")) {
                    return "zh";
                } else if(param.equals("ro.product.locale.region")) {
                    return "CN";
                } else if(param.equals("ro.board.platform")) {
                    return "msm7627a";
                } else if(param.equals("ro.build.product")) {
                    return "kyleplusctc";
                } else if(param.equals("ro.build.description")) {
                    return "kyleplusctc-user 4.1.2 JZO54K I739KEAMF1 release-keys";
                } else if(param.equals("ro.build.fingerprint")) {
                    return "samsung/kyleplusctc/kyleplusctc:4.1.2/JZO54K/I739KEAMF1:user/release-keys";
                } else if(param.equals("ro.build.characteristics")) {
                    return "china_wlan,china_cdma";
                } else if(param.equals("ro.build.PDA")) {
                    return "I739KEAMF1";
                } else if(param.equals("ro.build.hidden_ver")) {
                    return "I739KEAMF1";
                } else if(param.equals("ro.build.changelist")) {
                    return 1283033;
                } else if(param.equals("ro.opengles.version")) {
                    return 131072;
                } else if(param.equals("ro.use_data_netmgrd")) {
                    return true;
                } else if(param.equals("ro.bluetooth.request.master")) {
                    return true;
                } else if(param.equals("ro.qualcomm.bluetooth.ftp")) {
                    return true;
                } else if(param.equals("ro.qualcomm.bluetooth.sap")) {
                    return true;
                } else if(param.equals("ro.bluetooth.remote.autoconnect")) {
                    return true;
                } else if(param.equals("ro.config.ehrpd")) {
                    return true;
                } else if(param.equals("ro.qualcomm.cabl")) {
                    return 1;
                } else if(param.equals("ro.fm.analogpath.supported")) {
                    return true;
                } else if(param.equals("ro.fm.transmitter")) {
                    return false;
                } else if(param.equals("ro.fm.mulinst.recording.support")) {
                    return false;
                } else if(param.equals("ro.emmc.sdcard.partition")) {
                    return 18;
                } else if(param.equals("ro.screen.layout")) {
                    return "normal";
                } else if(param.equals("ro.staticwallpaper.pixelformat")) {
                    return "RGB_565";
                } else if(param.equals("ro.max.fling_velocity")) {
                    return 4000;
                } else if(param.equals("ro.telephony.default_network")) {
                    return 10;
                } else if(param.equals("ro.cdma.ecmexittimer")) {
                    return 0;
                } else if(param.equals("ro.config.combined_signal")) {
                    return true;
                } else if(param.equals("ro.kernel.qemu")) {
                    return 0;
                } else if(param.equals("ro.carrier")) {
                    return "unknown";
                } else if(param.equals("ro.com.google.clientidbase")) {
                    return "android-samsung";
                } else if(param.equals("ro.ril.hsxpa")) {
                    return 1;
                } else if(param.equals("ro.ril.gprsclass")) {
                    return 10;
                } else if(param.equals("ro.adb.qemud")) {
                    return 1;
                } else if(param.equals("ro.setupwizard.mode")) {
                    return "OPTIONAL";
                } else if(param.equals("ro.debuggable")) {
                    return 0;
                } else if(param.equals("ro.secure")) {
                    return 1;
                }
                return "";
            }
        });

        XposedBridge.hookAllMethods(Class.forName("android.os.SystemProperties"), "getString", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                String param = ((String[]) methodHookParam.args)[0];
                if(param.equals("ro.build.id")) {
                    return "JZO54K";
                } else if(param.equals("ro.build.display.id")) {
                    return "JZO54K.I739KEAMF1";
                } else if(param.equals("ro.build.version.incremental")) {
                    return "I739KEAMF1";
                } else if(param.equals("ro.build.version.codename")) {
                    return "REL";
                } else if(param.equals("ro.build.version.release")) {
                    return "4.1.2";
                } else if(param.equals("ro.build.date")) {
                    return "Wed Jun 26 12:36:29 KST 2013";
                } else if(param.equals("ro.build.type")) {
                    return "user";
                } else if(param.equals("ro.build.user")) {
                    return "se.infra";
                } else if(param.equals("ro.build.host")) {
                    return "S0210-08";
                } else if(param.equals("ro.build.tags")) {
                    return "release-keys";
                } else if(param.equals("ro.product.model")) {
                    return "SCH-I739";
                } else if(param.equals("ro.product.brand")) {
                    return "samsung";
                } else if(param.equals("ro.product.name")) {
                    return "kyleplusctc";
                } else if(param.equals("ro.product.device")) {
                    return "kyleplusctc";
                } else if(param.equals("ro.product.board")) {
                    return "MSM8625";
                } else if(param.equals("ro.product.cpu.abi")) {
                    return "armeabi-v7a";
                } else if(param.equals("ro.product.cpu.abi2")) {
                    return "armeabi";
                } else if(param.equals("ro.product_ship")) {
                    return "true";
                } else if(param.equals("ro.product.manufacturer")) {
                    return "samsung";
                } else if(param.equals("ro.product.locale.language")) {
                    return "zh";
                } else if(param.equals("ro.product.locale.region")) {
                    return "CN";
                } else if(param.equals("ro.board.platform")) {
                    return "msm7627a";
                } else if(param.equals("ro.build.product")) {
                    return "kyleplusctc";
                } else if(param.equals("ro.build.description")) {
                    return "kyleplusctc-user 4.1.2 JZO54K I739KEAMF1 release-keys";
                } else if(param.equals("ro.build.fingerprint")) {
                    return "samsung/kyleplusctc/kyleplusctc:4.1.2/JZO54K/I739KEAMF1:user/release-keys";
                } else if(param.equals("ro.build.characteristics")) {
                    return "china_wlan,china_cdma";
                } else if(param.equals("ro.build.PDA")) {
                    return "I739KEAMF1";
                } else if(param.equals("ro.build.hidden_ver")) {
                    return "I739KEAMF1";
                } else if(param.equals("ro.screen.layout")) {
                    return "normal";
                } else if(param.equals("ro.staticwallpaper.pixelformat")) {
                    return "RGB_565";
                } else if(param.equals("ro.carrier")) {
                    return "unknown";
                } else if(param.equals("ro.com.google.clientidbase")) {
                    return "android-samsung";
                } else if(param.equals("ro.setupwizard.mode")) {
                    return "OPTIONAL";
                }
                return "";
            }
        });

        XposedBridge.hookAllMethods(Class.forName("android.os.SystemProperties"), "getInt", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                String param = ((String[]) methodHookParam.args)[0];
                if(param.equals("ro.build.version.sdk")) {
                    return 16;
                } else if(param.equals("ro.kernel.qemu")) {
                    return 0;
                } else if(param.equals("ro.ril.hsxpa")) {
                    return 1;
                } else if(param.equals("ro.ril.gprsclass")) {
                    return 10;
                } else if(param.equals("ro.adb.qemud")) {
                    return 1;
                } else if(param.equals("ro.debuggable")) {
                    return 0;
                } else if(param.equals("ro.secure")) {
                    return 1;
                }
                return 1;
            }
        });

        XposedBridge.hookAllMethods(Class.forName("android.os.SystemProperties"), "get", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                String param = ((String[]) methodHookParam.args)[0];
                if(param.equals("ro.build.date.utc")) {
                    return 1372217789000l;
                }
                return 0l;
            }
        });

        XposedBridge.hookAllMethods(Class.forName("android.os.SystemProperties"), "getBoolean", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                String param = ((String[]) methodHookParam.args)[0];
                if(param.equals("ro.use_data_netmgrd")) {
                    return true;
                } else if(param.equals("ro.bluetooth.request.master")) {
                    return true;
                } else if(param.equals("ro.qualcomm.bluetooth.ftp")) {
                    return true;
                } else if(param.equals("ro.qualcomm.bluetooth.sap")) {
                    return true;
                } else if(param.equals("ro.bluetooth.remote.autoconnect")) {
                    return true;
                } else if(param.equals("ro.config.ehrpd")) {
                    return true;
                } else if(param.equals("ro.fm.analogpath.supported")) {
                    return true;
                } else if(param.equals("ro.fm.transmitter")) {
                    return false;
                } else if(param.equals("ro.fm.mulinst.recording.support")) {
                    return false;
                } else if(param.equals("ro.config.combined_signal")) {
                    return true;
                }
                return false;
            }
        });
    }
}
