import _root_.sbtassembly.Plugin.AssemblyKeys
import AssemblyKeys._
import _root_.sbtassembly.Plugin.AssemblyKeys._
import _root_.sbtassembly.Plugin.MergeStrategy
import _root_.sbtassembly.Plugin._

// put this at the top of the file

assemblySettings

mergeStrategy in assembly := {
  case n if n.startsWith("META-INF") => MergeStrategy.discard
  case n if n.contains("Log$Logger.class") => MergeStrategy.last
  case n if n.contains("Log.class") => MergeStrategy.last
  case n if n.contains("META-INF/MANIFEST.MF") => MergeStrategy.discard
  case n if n.contains("commons-beanutils") => MergeStrategy.discard
  case _ => MergeStrategy.first
}
