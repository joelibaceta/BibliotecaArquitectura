package main;

import core.BorrowPolicy;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class PluginLoader {
    private static final String PLUGINS_DIR = "plugins";

    public List<BorrowPolicy> loadPlugins() {
        List<BorrowPolicy> policies = new ArrayList<>();

        File pluginDir = new File(PLUGINS_DIR);
        if (!pluginDir.exists() || !pluginDir.isDirectory()) {
            System.out.println("No se encontró la carpeta de plugins.");
            return policies;
        }

        File[] files = pluginDir.listFiles((dir, name) -> name.endsWith(".class"));
        if (files == null) return policies;

        for (File file : files) {
            try {
                String className = file.getName().replace(".class", "");
                URL[] urls = {pluginDir.toURI().toURL()};
                URLClassLoader classLoader = new URLClassLoader(urls);

                Class<?> loadedClass = classLoader.loadClass(className);

                if (BorrowPolicy.class.isAssignableFrom(loadedClass)) {
                    BorrowPolicy policy = (BorrowPolicy) loadedClass.getDeclaredConstructor().newInstance();
                    policies.add(policy);
                }
            } catch (Exception e) {
                System.out.println("Error cargando plugin: " + file.getName());
                e.printStackTrace();
            }
        }
        return policies;
    }
}